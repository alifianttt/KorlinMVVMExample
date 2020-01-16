package com.yoga.tugasapikotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoga.tugasapikotlin.R
import com.yoga.tugasapikotlin.model.DataWisata
import kotlinx.android.synthetic.main.item_wisata.view.*

class DataAdapter (val data:List<DataWisata>):RecyclerView.Adapter<DataAdapter.holderView>(){
    class holderView(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindview(get:DataWisata){
            itemView.dst_name.text = get.dstName
            itemView.dst_author.text = get.dstAuthor
            itemView.created_at.text = get.createAt
            itemView.update_at.text = get.updateAt
            itemView.dst_category.text = get.dstCategory
            itemView.dst_lat.text = get.dstLat
            itemView.dst_long.text = get.dstLong
            itemView.dst_addr.text = get.dstAddr
            itemView.dst_rating.text = get.dstRating
            itemView.dst_respon.text = get.dstRespon
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = holderView(LayoutInflater.from(parent.context).inflate(
        R.layout.item_wisata, parent, false))

    override fun getItemCount(): Int {
        return data.size?: 0
    }

    override fun onBindViewHolder(holder: DataAdapter.holderView, position: Int) {
        holder.bindview(data.get(position))
    }
}