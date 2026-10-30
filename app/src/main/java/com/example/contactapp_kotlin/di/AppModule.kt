package com.example.contactapp_kotlin.di

import android.content.Context
import androidx.room.Room
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository
import com.example.contactapp_kotlin.data.room.Database
import com.example.contactapp_kotlin.data.room.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDaoRepository(personDao: PersonDao): PersonDaoRepository {
        return PersonDaoRepository(personDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(@ApplicationContext context: Context): PersonDao {
        val db = Room.databaseBuilder(context, Database::class.java, "contacts.sqlite")
            .createFromAsset("contacts.sqlite")
            .build()

        return db.getAll()
    }
}