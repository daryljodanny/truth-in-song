package dev.rtrilia.truthinsong.ui.malayalam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.qtalk.recyclerviewfastscroller.RecyclerViewFastScroller
import dev.rtrilia.truthinsong.databinding.ItemMalayalamListBinding
import dev.rtrilia.truthinsong.models.MalayalamList


class MalayalamListAdapter(private val clickClickListener: MalayalamListItemClickListener) :
    PagedListAdapter<MalayalamList, MalayalamListAdapter.ViewHolder>(MalayalamListDiffCallback), RecyclerViewFastScroller.OnPopupTextUpdate {

    companion object MalayalamListDiffCallback : DiffUtil.ItemCallback<MalayalamList>() {
        override fun areItemsTheSame(oldItem: MalayalamList, newItem: MalayalamList): Boolean {
            return oldItem.song_id == newItem.song_id
        }

        override fun areContentsTheSame(oldItem: MalayalamList, newItem: MalayalamList): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(val binding: ItemMalayalamListBinding) : RecyclerView.ViewHolder(binding.root)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMalayalamListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = getItem(position)
        holder.binding.model = listItem
        holder.binding.clickListener = clickClickListener
    }

    override fun onChange(position: Int): CharSequence {
        return getItem(position)?.song_id.toString()
    }

}
