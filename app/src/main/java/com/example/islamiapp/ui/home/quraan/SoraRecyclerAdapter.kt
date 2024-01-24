package com.example.islamiapp.ui.home.quraan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemSoraTitleBinding

class SoraRecyclerAdapter(private val soraList: List<String>) : RecyclerView.Adapter<SoraRecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding :ItemSoraTitleBinding =
            ItemSoraTitleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)

    }

    override fun getItemCount(): Int = soraList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = soraList[position]
        holder.bind(title)

        //check on specific variable null or not  , will enter let if not nullable
        onItemClickListener?.let { listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(title, position)
            }
        }
        /*Let is Instead of
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener{
                onItemClickListener?.onItemClick(title,position)
            }
        }*/
    }
    var onItemClickListener:OnItemClickListener?=null
    fun interface OnItemClickListener{
        fun onItemClick(item:String,position: Int)
    }

    class ViewHolder(private val itemBinding: ItemSoraTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }

}
