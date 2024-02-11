package ru.aurorahost.stayraterapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.aurorahost.stayraterapp.data.repository.DataStoreOperationsImpl
import ru.aurorahost.stayraterapp.data.repository.Repository
import ru.aurorahost.stayraterapp.domain.repository.DataStoreOperations
import ru.aurorahost.stayraterapp.domain.use_cases.UseCases
import ru.aurorahost.stayraterapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import ru.aurorahost.stayraterapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }

}