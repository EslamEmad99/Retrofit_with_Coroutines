package eslam.emad.retrofitcoroutines.di

import dagger.Component
import eslam.emad.retrofitcoroutines.api.ApiInterface
import javax.inject.Singleton

@Singleton
@Component (modules = [AppModule::class])
interface AppComponent {

    fun getApiService(): ApiInterface
}