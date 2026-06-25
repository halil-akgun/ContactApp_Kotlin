package com.example.contactapp_kotlin.di

import com.example.contactapp_kotlin.data.repo.PersonDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDaoRepository(): PersonDaoRepository {
        return PersonDaoRepository()
    }
}