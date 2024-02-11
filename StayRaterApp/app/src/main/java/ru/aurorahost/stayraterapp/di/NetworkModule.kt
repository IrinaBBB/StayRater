package ru.aurorahost.stayraterapp.di

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.aurorahost.stayraterapp.data.local.StayRaterDb
import ru.aurorahost.stayraterapp.data.remote.StayRaterApi
import ru.aurorahost.stayraterapp.data.repository.RemoteDataSourceImpl
import ru.aurorahost.stayraterapp.domain.repository.RemoteDataSource
import ru.aurorahost.stayraterapp.util.Constants.BASE_URL
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideStayRaterApi(retrofit: Retrofit): StayRaterApi {
        return retrofit.create(StayRaterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        stayRaterApi: StayRaterApi,
        stayRaterDb: StayRaterDb
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            stayRaterApi = stayRaterApi,
            stayRaterDb = stayRaterDb
        )
    }
}