package com.hugorafaelcosta.brewerybees

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hugorafaelcosta.brewerybees.adapter.BreweryAdapter
import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import com.hugorafaelcosta.brewerybees.domain.Brewery
import com.hugorafaelcosta.brewerybees.viewModel.BreweryMainViewModel
import com.hugorafaelcosta.brewerybees.viewModel.BreweryViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

      private lateinit var breweryAdapter: BreweryAdapter
    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerview_main)
    }

    val viewModel by lazy {
        ViewModelProvider(this, BreweryViewModelFactory())
            .get(BreweryMainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_BreweryBEES)

        setContentView(R.layout.activity_main)

        viewModel.brewery.observe(this) {
            loadRecyclerView(it)
        }
    }

    private fun loadRecyclerView(brewerys: List<BreweryModel?>) {
        this.breweryAdapter = BreweryAdapter(brewerys)

        val horizontalLayoutManagaer =LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(horizontalLayoutManagaer)

        recyclerView.layoutManager =LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = this.breweryAdapter

//        recyclerView.layoutManager =LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView.adapter = BreweryAdapter(brewerys)
    }

//        initRecyclerView()
//        addDataSource()
}

//    private fun addDataSource() {
//       val dataSource = com.hugorafaelcosta.DataSource.createDataSet()
//        this.breweryAdapter.setDataSet(dataSource)
//    }
//
//    private fun initRecyclerView() {
//        this.breweryAdapter = BreweryAdapter()
//
//        val horizontalLayoutManagaer =LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerview_main.setLayoutManager(horizontalLayoutManagaer)
//
////        recyclerview_main.layoutManager =LinearLayoutManager(this@MainActivity)
//        recyclerview_main.adapter = this.breweryAdapter
//    }

