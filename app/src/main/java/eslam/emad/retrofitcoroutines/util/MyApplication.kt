package eslam.emad.retrofitcoroutines.util

import android.app.Application
import eslam.emad.retrofitcoroutines.api.ApiInterface
import eslam.emad.retrofitcoroutines.di.DaggerAppComponent

class MyApplication : Application() {

    companion object {
        lateinit var apiService: ApiInterface
    }

    override fun onCreate() {
        super.onCreate()
        apiService = DaggerAppComponent.create().getApiService()
    }
}