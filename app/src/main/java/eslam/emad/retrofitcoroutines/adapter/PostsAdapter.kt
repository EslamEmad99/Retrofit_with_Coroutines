package eslam.emad.retrofitcoroutines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import eslam.emad.retrofitcoroutines.R
import eslam.emad.retrofitcoroutines.databinding.ExamplePostBinding
import eslam.emad.retrofitcoroutines.model.Post

class PostsAdapter(private var myList: List<Post>) : RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ExamplePostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.example_post,
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.post = myList[position]
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    class MyViewHolder(var binding: ExamplePostBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}