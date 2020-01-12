package com.example.countryapp_jetpack.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.countryapp_jetpack.R
import com.example.countryapp_jetpack.adapter.CountryAdapter
import com.example.countryapp_jetpack.entity.CountryEntity
import com.example.countryapp_jetpack.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.apply {
            getIsLoading().observe(this@MainActivity, Observer { isLoading -> loadProgressBar(isLoading) })
            getAllCountryList()?.observe(this@MainActivity, Observer { countryList -> showCountryList(countryList) })
        }
    }

    private fun loadProgressBar(isLoading: Boolean) {
        if (isLoading) {
            progreassBar.visibility = View.VISIBLE
            countryRecyclerView.visibility = View.GONE
        } else {
            progreassBar.visibility = View.GONE
            countryRecyclerView.visibility = View.VISIBLE
        }
    }

    private fun showCountryList(countryList: List<CountryEntity>) {
        val countryAdapter = CountryAdapter(this,countryList)
        countryRecyclerView?.apply {
            adapter = countryAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }
}
