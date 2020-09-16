package eslam.emad.retrofitcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsViewModel : ViewModel() {
    private var postsMutableLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPosts(): LiveData<List<Post>> {
        viewModelScope.launch {
            val response = ApiClient.getPosts()
            if (response.isSuccessful){
                withContext(Main){
                    postsMutableLiveData.value = response.body()!!
                }
            }
        }
        return postsMutableLiveData
    }
}