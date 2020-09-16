package eslam.emad.retrofitcoroutines

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{

    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    private val apiService: ApiInterface by lazy {

        retrofitBuilder
            .build()
            .create(ApiInterface::class.java)
    }

    suspend fun getPosts(): Response<List<Post>>{
        return apiService.getPosts()
    }
}