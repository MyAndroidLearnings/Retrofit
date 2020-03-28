package com.example.retrofitsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import java.lang.Exception

class AdapterClass(var dataList: ArrayList<ModelClass>, var context: Context) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.data_adapter,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.nameText.text = dataList.get(position).name
        }catch (e:Exception){
            e.printStackTrace()
            println("*****"+e.toString())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var nameText:TextView
        init {
            nameText = itemView.findViewById(R.id.nametext)
        }
    }

}
