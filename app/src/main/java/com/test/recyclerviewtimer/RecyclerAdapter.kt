package com.test.recyclerviewtimer

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val data1: ArrayList<ViewModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View, val data1: ArrayList<ViewModel>) : RecyclerView.ViewHolder(view) {

        var tvText = view.findViewById<TextView>(R.id.tvtext)
        var btn = view.findViewById<Button>(R.id.btn)

        fun startTimer(position: Int) {
            Handler().postDelayed({
                data1[position].time = data1[position].time - 1

                if (data1[position].time > 0 && data1[position].continuee) {
                    startTimer(position)
                }
            }, 1000)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return ViewHolder(view, data1)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.tvText.text = holder.data1[position].time.toString()

        holder.btn.setOnClickListener {
            holder.data1[position].continuee = !holder.data1[position].continuee
            holder.startTimer(position)
        }


    }

    override fun getItemCount(): Int {
        return 20
    }
}