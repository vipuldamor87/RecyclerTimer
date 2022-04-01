package com.test.recyclerviewtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = ArrayList<ViewModel>()
        for (i in 0..20) {
            data.add(ViewModel(60))
            data.get(0)

        }
        var adapter = RecyclerAdapter(data)

        RvView.layoutManager = LinearLayoutManager(this)
        RvView.adapter =adapter
        reload(adapter)



    }
    fun reload(adapter: RecyclerAdapter) {
        Handler().postDelayed({
            adapter.notifyDataSetChanged()
            Log.d("asd","done")
            reload(adapter)
        },1000)
    }
}