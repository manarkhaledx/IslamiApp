package com.example.islamiapp.ui.soraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemSoraTitleBinding
import com.example.islamiapp.databinding.ItemSoraVerseBinding

class VersesRecyclerAdapter(private val versesList: List<String>) : RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding :ItemSoraVerseBinding =
            ItemSoraVerseBinding .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)

    }

    override fun getItemCount(): Int = versesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = versesList[position]
        holder.bind(title)

        //check on specific variable null or not  , will enter let if not nullable
        onItemClickListener?.let { listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(title, position)
            }
        }

    }
    var onItemClickListener:OnItemClickListener?=null
    fun interface OnItemClickListener{
        fun onItemClick(item:String,position: Int)
    }

    class ViewHolder(val itemBinding: ItemSoraVerseBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(title:String){
            itemBinding.content.text=title
        }
    }

}
