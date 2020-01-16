package com.yoga.tugasapikotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.tugasapikotlin.R
import com.yoga.tugasapikotlin.adapter.DataAdapter
import com.yoga.tugasapikotlin.model.DataWisata
import com.yoga.tugasapikotlin.viewmodel.MyDataViewModel
import com.yoga.tugasapikotlin.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel : MyViewModel
    private lateinit var dataModel : MyDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        dataModel = ViewModelProviders.of(this).get(MyDataViewModel::class.java)
        //dataModel.Insert()
        viewModel.getData(0, 3)
        viewModel.getStatus().observe(
            this, Observer {
                t ->
                if (t ?: true){
                    rv_wisata.visibility = View.GONE
                } else {
                    rv_wisata.visibility = View.VISIBLE
                }
            }
        )
        viewModel.setData().observe(this, Observer {
            t ->
            t?.data?.let { showData(it) }
        })
    }

    private fun showData(data: List<DataWisata>){
        rv_wisata.adapter = DataAdapter(data)
        rv_wisata.layoutManager = LinearLayoutManager(this)
        Log.d("isi : ", data.toString())
    }
}
