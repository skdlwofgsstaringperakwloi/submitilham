package com.example.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bahrudin.bagus.submitilham.Fighter
import bahrudin.bagus.submitilham.R
import bahrudin.bagus.submitilham.fighter_details
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFighterAdapter(val listFighter: ArrayList<Fighter>) : RecyclerView.Adapter<ListFighterAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_fighter, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFighter.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, ranking, foto, deskripsi, identitas) = listFighter[position]

        // menggunakan library Glide untuk request gambar
        Glide.with(holder.itemView.context)
            .load(foto)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = nama
        holder.tvRank.text = ranking

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, fighter_details::class.java)
            moveDetail.putExtra(fighter_details.EXTRA_RANKING, ranking)
            moveDetail.putExtra(fighter_details.EXTRA_NAMA, nama)
            moveDetail.putExtra(fighter_details.EXTRA_FOTO, foto)
            moveDetail.putExtra(fighter_details.EXTRA_IDENTITAS, identitas)
            moveDetail.putExtra(fighter_details.EXTRA_DESKRIPSI, deskripsi)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_fighter)
        var tvRank: TextView = itemView.findViewById(R.id.tv_rank)
        var imgPhoto: ImageView = itemView.findViewById(R.id.foto)
    }

}