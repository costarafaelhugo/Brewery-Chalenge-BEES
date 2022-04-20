package com.hugorafaelcosta.brewerybees

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugorafaelcosta.brewerybees.adapter.BreweryAdapter
import com.hugorafaelcosta.brewerybees.repository.BreweryRepository
import com.hugorafaelcosta.brewerybees.rest.BreweryInterface
import com.hugorafaelcosta.brewerybees.viewModel.BreweryMainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var breweryAdapter: BreweryAdapter
    private val viewModel = BreweryMainViewModel(BreweryRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Thread.sleep(2000)

        setTheme(R.style.Theme_BreweryBEES)

        setContentView(R.layout.activity_main)

        initRecyclerView()
//        addDataSource()
        viewModel.getBreweryList()

        viewModel.brewery.observe(this){brewerys ->
            if (brewerys != null) {
                this.breweryAdapter.setDataSet(brewerys)
            }
        }
    }

//    private fun addDataSource() {
//       val dataSource = BreweryInterface.getInstance()
//
//      // this.breweryAdapter.setDataSet()
//    }


    private fun initRecyclerView() {
        this.breweryAdapter = BreweryAdapter()

        val horizontalLayoutManagaer =LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerview_main.layoutManager = horizontalLayoutManagaer

//        recyclerview_main.layoutManager =LinearLayoutManager(this@MainActivity)
        recyclerview_main.adapter = this.breweryAdapter
    }



}