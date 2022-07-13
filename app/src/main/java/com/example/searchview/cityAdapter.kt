package com.example.searchview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class cityAdapter(val mainActivity: MainActivity, var city: ArrayList<String>) : RecyclerView.Adapter<cityAdapter.ViewData>() {

    class ViewData(itemView : View) :  RecyclerView.ViewHolder(itemView)
    {

        var titel_txt = itemView.findViewById<TextView>(R.id.titel_txt)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.itemview,parent,false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.titel_txt.text=city[position]
    }

    override fun getItemCount(): Int {
        return city.size
    }

    fun filter(filterlist: java.util.ArrayList<String>) {
        city = filterlist
        notifyDataSetChanged()
    }
}