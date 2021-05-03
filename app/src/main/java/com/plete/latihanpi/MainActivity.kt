package com.plete.latihanpi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListOfDataIntoRecyclerView()
    }

    fun setupListOfDataIntoRecyclerView(){
        rvItemList.layoutManager = LinearLayoutManager(this)

        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getAPI().enqueue(object : Callback<ArrayList<ApiModel>> {
            override fun onFailure(call: Call<ArrayList<ApiModel>>?, t: Throwable){
                Toast.makeText(baseContext, "Data Downloading is failed", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ArrayList<ApiModel>>?,
                response: Response<ArrayList<ApiModel>>
            ){
                var apiData = response?.body()!!
                if (apiData.size > 0){
                    rvItemList.visibility = View.VISIBLE
                    tvNoRecordAvailable.visibility = View.GONE
                    rvItemList.adapter = ApiAdapter(this@MainActivity, apiData)
                } else {
                    rvItemList.visibility = View.GONE
                    tvNoRecordAvailable.visibility = View.VISIBLE
                }
                Toast.makeText(baseContext, "Data Downloading is Successfully", Toast.LENGTH_LONG).show()
            }
        })
    }
}