package com.example.retrofitsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    var retrofit: Retrofit? = null
    lateinit var recyclerview:RecyclerView
    var dataList = ArrayList<ModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            recyclerview = findViewById(R.id.recyclerview)
            recyclerview.setHasFixedSize(true)
            recyclerview.layoutManager = LinearLayoutManager(this)

            connectandGetApiData()
        }catch (e:Exception){
            e.printStackTrace()
            println("@@@@@"+e.toString())
        }
    }

    fun connectandGetApiData() {
        try {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://simplifiedcoding.net/demos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            var apiInterface: ApiInterface = retrofit!!.create(ApiInterface::class.java)
            var call: Call<List<ModelClass>> = apiInterface.getValues()

            call.enqueue(object : Callback<List<ModelClass>> {
                override fun onFailure(call: Call<List<ModelClass>>, t: Throwable) {
                    Toast.makeText(getApplicationContext(), t.message, Toast.LENGTH_SHORT).show();
                }

                override fun onResponse(
                    call: Call<List<ModelClass>>,
                    response: Response<List<ModelClass>>
                ) {
                    dataList.addAll(response!!.body()!!)
                    recyclerview.adapter = AdapterClass(dataList, this@MainActivity)
                    recyclerview.adapter!!.notifyDataSetChanged()
                }
            })
        }catch (e:Exception){
            e.printStackTrace()
            println("#####"+e.toString())
        }
    }
}
