package com.example.meettotapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meettotapp.R
import com.example.meettotapp.model.IncomeExpenseModel

class DataAdapter(val context: Context,val list :ArrayList<IncomeExpenseModel>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : ViewHolder(itemView)
    {
        var txtDataTitle =itemView.findViewById<TextView>(R.id.txtDataTitle)
        var txtDataId =itemView.findViewById<TextView>(R.id.txtDataId)
        var txtDataAmount =itemView.findViewById<TextView>(R.id.txtDataAmount)
        var txtDataNotes =itemView.findViewById<TextView>(R.id.txtDataNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.data_item,parent,false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
       holder.txtDataTitle.text = list.get(position).title
       holder.txtDataAmount.text = list.get(position).amount.toString()
       holder.txtDataNotes.text = list.get(position).notes
    }
}