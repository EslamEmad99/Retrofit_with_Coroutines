package eslam.emad.retrofitcoroutines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eslam.emad.retrofitcoroutines.R
import eslam.emad.retrofitcoroutines.databinding.ExamplePostBinding
import eslam.emad.retrofitcoroutines.model.Post

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ExamplePostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.example_post,
            parent, false
        )
        return MyViewHolder(binding)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.post = differ.currentList[position]
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class MyViewHolder(var binding: ExamplePostBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}