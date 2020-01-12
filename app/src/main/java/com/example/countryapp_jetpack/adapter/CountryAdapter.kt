package com.example.countryapp_jetpack.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp_jetpack.R
import com.example.countryapp_jetpack.entity.CountryEntity

class CountryAdapter(private val context: Context, private val countryList: List<CountryEntity>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_country_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.apply {
            countryName.text = "Country Name : ${country.name}"
            countryCapital.text = "Capital : ${country.capital}"
            countryPopulation.text = "Population : ${country.population}"
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val countryCapital: TextView = itemView.findViewById(R.id.country_capital)
        val countryPopulation: TextView = itemView.findViewById(R.id.country_population)
    }

}