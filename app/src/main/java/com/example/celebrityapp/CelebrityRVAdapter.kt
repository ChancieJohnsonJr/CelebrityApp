package com.example.celebrityapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.celebrityapp.CelebrityCallback
import com.example.celebrityapp.R
import kotlinx.android.synthetic.main.celebrity_item.view.*

class CelebrityRVAdapter(var celebrityList : ArrayList<Celebrity>, val callback: CelebrityCallback)
    : RecyclerView.Adapter<CelebrityRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.celebrity_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.populateCelebrityItem(celebrityList[position])

    override fun getItemCount() = celebrityList.size

    fun updateList(passedList: ArrayList<Celebrity>) {
        celebrityList = passedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateCelebrityItem(celebrity: Celebrity) {
            itemView.tvFirstName.text = celebrity.firstName
            itemView.tvLastName.text = celebrity.lastName
            itemView.tvCelebID.text = celebrity.celebId
            itemView.tvIsFavorite.text = celebrity.isFavorite
            itemView.setOnClickListener { callback.passCelebrity(celebrity) }
        }
    }

}