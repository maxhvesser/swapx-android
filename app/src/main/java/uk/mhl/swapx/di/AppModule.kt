package uk.mhl.swapx.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.mhl.swapx.data.database.ExchangeDatabase
import uk.mhl.swapx.data.database.dao.ExchangeDao
import uk.mhl.swapx.data.network.ExchangeApi
import uk.mhl.swapx.data.network.ExchangeService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // region Network

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideBaseUrl(): String = ExchangeApi.BaseUrl

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideExchangeService(retrofit: Retrofit): ExchangeService = retrofit
        .create(ExchangeService::class.java)

    // endregion

    // region Database

    @Singleton
    @Provides
    fun provideExchangeDatabase(@ApplicationContext context: Context): ExchangeDatabase = Room
        .databaseBuilder(
            context,
            ExchangeDatabase::class.java,
            "exchange-database"
        )
        .build()

    @Singleton
    @Provides
    fun provideExchangeDao(database: ExchangeDatabase): ExchangeDao = database.exchangeDao()

    // endregion

}