package dev.rtrilia.truthinsong.ui.english

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.rtrilia.truthinsong.data.models.EnglishList
import dev.rtrilia.truthinsong.databinding.ItemEnglishListBinding

class EnglishListAdapter(val onClick: (EnglishList) -> Unit) :
    PagedListAdapter<EnglishList, EnglishListAdapter.ViewHolder>(EnglishListDiffCallback) {

    companion object EnglishListDiffCallback : DiffUtil.ItemCallback<EnglishList>() {
        override fun areItemsTheSame(oldItem: EnglishList, newItem: EnglishList): Boolean {
            return oldItem.song_id == newItem.song_id
        }

        override fun areContentsTheSame(oldItem: EnglishList, newItem: EnglishList): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(val binding: ItemEnglishListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEnglishListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = getItem(holder.bindingAdapterPosition)
        holder.binding.clickListener = this
    }

}




