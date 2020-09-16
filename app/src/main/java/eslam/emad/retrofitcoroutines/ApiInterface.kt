package eslam.emad.retrofitcoroutines

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}