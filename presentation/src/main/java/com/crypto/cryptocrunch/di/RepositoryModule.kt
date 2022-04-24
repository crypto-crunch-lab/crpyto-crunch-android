package com.crypto.cryptocrunch.di
import com.crypto.cryptocrunch.data.datasource.local.HomeDataSource
import com.crypto.cryptocrunch.data.repository.HomeRepositoryImpl
import com.crypto.cryptocrunch.domain.repository.HomeRepository
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideStartRepository(homeDataSource: HomeDataSource) : HomeRepository {
        return HomeRepositoryImpl(homeDataSource)
    }


}