package ru.aurorahost.stayraterapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.aurorahost.stayraterapp.data.local.StayRaterDb
import ru.aurorahost.stayraterapp.util.Constants.STAY_RATER_DB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        StayRaterDb::class.java,
        STAY_RATER_DB
    ).build()

}