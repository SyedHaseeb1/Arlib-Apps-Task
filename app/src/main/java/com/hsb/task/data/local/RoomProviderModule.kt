package com.hsb.task.data.local

import android.content.Context
import androidx.room.Room
import com.hsb.task.data.local.dao.DrugDao
import com.hsb.task.data.local.dao.LabDao
import com.hsb.task.data.remote.ApiService
import com.hsb.task.domain.repository.DrugRepository
import com.hsb.task.domain.repository.DrugRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomProviderModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "drug_database"
        ).build()
    }

    @Provides
    fun provideDrugDao(db: AppDatabase): DrugDao {
        return db.drugDao()
    }

    @Provides
    fun provideLabDao(db: AppDatabase): LabDao {
        return db.labDao()
    }

    @Provides
    fun provideRepository(
        apiService: ApiService,
        drugDao: DrugDao,
        labDao: LabDao,
        @ApplicationContext context: Context
    ): DrugRepository {
        return DrugRepositoryImpl(apiService, drugDao, labDao, context)
    }
}
