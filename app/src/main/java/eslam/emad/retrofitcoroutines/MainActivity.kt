package eslam.emad.retrofitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import eslam.emad.retrofitcoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var postsAdapter: PostsAdapter
        val binding: ActivityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        var viewModel: PostsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        viewModel.getPosts().observe(this, {
            postsAdapter = PostsAdapter(it)
            binding.recyclerview.adapter = postsAdapter
        })
    }
}