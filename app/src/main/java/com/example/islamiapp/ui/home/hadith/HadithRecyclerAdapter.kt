package com.example.islamiapp.ui.soraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemSoraVerseBinding
import com.example.islamiapp.model.Hadith

class HadithRecyclerAdapter(private val hadithList: List<Hadith>) : RecyclerView.Adapter<HadithRecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding :ItemSoraVerseBinding =
            ItemSoraVerseBinding .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)

    }

    override fun getItemCount(): Int = hadithList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadith = hadithList[position]
        holder.bind(hadith.title)

        //check on specific variable null or not  , will enter let if not nullable
//

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
