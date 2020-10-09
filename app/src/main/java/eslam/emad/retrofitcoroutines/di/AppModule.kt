package eslam.emad.retrofitcoroutines.di

import dagger.Module
import dagger.Provides
import eslam.emad.retrofitcoroutines.api.ApiInterface
import eslam.emad.retrofitcoroutines.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): ApiInterface {
        return retrofitBuilder
            .build()
            .create(ApiInterface::class.java)
    }
}