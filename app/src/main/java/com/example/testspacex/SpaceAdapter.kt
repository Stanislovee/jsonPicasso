package com.example.testspacex

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class SpaceAdapter(private  val xContext: Context, private  val  xSpaceList: ArrayList<Model>) :
        RecyclerView.Adapter<SpaceAdapter.SpaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceViewHolder {
        val v = LayoutInflater.from(xContext).inflate(R.layout.list_item, parent, false)
        return SpaceViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SpaceAdapter.SpaceViewHolder, position: Int) {
        val currentItem = xSpaceList[position]
        val shipImage = currentItem.getImageUrl()
        val shipId = currentItem.getShipId()
        val shipYear = currentItem.getYearBuilt()
        val shipName = currentItem.getShipName()
        holder.xTextViewName.text = "Name: $shipName"
        holder.xTextViewId.text = "Id: $shipId"
        holder.xTextViewYear.text = "Created in $shipYear"
        Picasso.get().load(shipImage).fit().centerInside().into(holder.xImageView)
    }

    override fun getItemCount(): Int {
        return xSpaceList.size
    }

    inner class SpaceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val xImageView: ImageView = itemView.findViewById(R.id.image_ship)
        val xTextViewId: TextView = itemView.findViewById(R.id.id_ship)
        val xTextViewName: TextView = itemView.findViewById(R.id.name_ship)
        val xTextViewYear: TextView = itemView.findViewById(R.id.year_ship)
    }
}