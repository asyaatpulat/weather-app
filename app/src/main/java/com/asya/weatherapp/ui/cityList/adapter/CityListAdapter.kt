package com.asya.weatherapp.ui.cityList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asya.weatherapp.R
import com.asya.weatherapp.ui.cityList.model.CityModel


class CityListAdapter(
    private val cityList: ArrayList<CityModel>,
    private val clickHandler: (String) -> Unit
) :
    RecyclerView.Adapter<CityListAdapter.CityListViewHolder>() {

    class CityListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindItems(cityModel: CityModel, clickHandler: (String) -> Unit) {
            val textView = itemView.findViewById<TextView>(R.id.textView)
            textView.text = cityModel.description
            itemView.setOnClickListener {
                clickHandler(cityModel.description)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListViewHolder {
        return CityListViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_city, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {
        holder.bindItems(
            cityModel = cityList[position],
            clickHandler = clickHandler
        )
    }

    override fun getItemCount(): Int {
        return cityList.size
    }
}