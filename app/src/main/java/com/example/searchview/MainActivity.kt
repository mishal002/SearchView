package com.example.searchview

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    /*ArrayList*/
    var city = arrayListOf("Surat",
        "Valsad",
        "Mumbai",
        "Amreli",
        "Junagadh",
        "Bharuch",
        "Goa",
        "Kota",
        "Rajkot",
        "Virpur")
    lateinit var adapter: cityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rv_view = findViewById<RecyclerView>(R.id.rv_view)
        var search_view = findViewById<SearchView>(R.id.search_view)

        /*RecyclerView*/

        setRV(rv_view)

        /*SearchView*/
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText!!)
                return false
            }
        })
    }

    /*Filter Code*/
    fun filterList(text: String) {
        var filterlist = arrayListOf<String>()
        for (x in city) {
            if (x.lowercase().contains(text.lowercase())) {
                filterlist.add(x)
            }
            adapter.filter(filterlist)
        }
    }

    /*Adapter*/
    fun setRV(rv_view: RecyclerView) {
        adapter = cityAdapter(this, city)
        var lm = LinearLayoutManager(this)
        rv_view.layoutManager = lm
        rv_view.adapter = adapter
    }


}