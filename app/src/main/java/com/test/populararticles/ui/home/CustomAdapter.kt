package com.test.populararticles.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofitdemo.model.Articles
import com.test.populararticles.R
import com.test.populararticles.model.ResponseList

class CustomAdapter (private var itemsList: List<Articles>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTitle: TextView? = null
        var itemByline: TextView? = null
        var itemDate: TextView? = null

        init {
            itemTitle = view.findViewById(R.id.textView2)
            itemByline = view.findViewById(R.id.textView)
            itemDate = view.findViewById(R.id.textView3)
        }

        fun bind(data : Articles){

                itemTitle?.text = data.title
                itemByline?.text = data.byline
                itemDate?.text = data.published_date


        }
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return itemsList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).bind(itemsList.get(position))

    }
}
