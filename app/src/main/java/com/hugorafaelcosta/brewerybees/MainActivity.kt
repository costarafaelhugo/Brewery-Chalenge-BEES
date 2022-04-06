package com.hugorafaelcosta.brewerybees

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugorafaelcosta.DataSource.Companion.createDataSet
import com.hugorafaelcosta.brewerybees.adapter.BreweryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {

    private lateinit var breweryAdapter: BreweryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_BreweryBEES)

        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource() {
       val dataSource = com.hugorafaelcosta.DataSource.createDataSet()
        this.breweryAdapter.setDataSet(dataSource)
    }

    private fun showAPIData(){
        val data =
    }

    private fun initRecyclerView() {
        this.breweryAdapter = BreweryAdapter()

        val horizontalLayoutManagaer =LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerview_main.setLayoutManager(horizontalLayoutManagaer)

//        recyclerview_main.layoutManager =LinearLayoutManager(this@MainActivity)
        recyclerview_main.adapter = this.breweryAdapter
    }

}