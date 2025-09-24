package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_week_06.R
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class CatAdapter(private val layoutInflater: LayoutInflater, private val imageLoader: GlideImageLoader) : RecyclerView.Adapter<CatViewHolder>(){
    //Mutable list for storing all the list data
    private var catList: List<CatModel> = emptyList()

    //A function to set the mutable List
    fun setData(newCatList: List<CatModel>){
        catList = newCatList

        //This is used to tell the adapter that there's a data change in the mutable list
        notifyDataSetChanged()
    }

    //A view holder is used to bind the data to the layout views
    //onCreateViewHolder is instantiating the view holder it self
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        val context = parent.context
        return CatViewHolder(view, GlideImageLoader(context))
    }

    //This is used to get the amount of data/item in the list
    override fun getItemCount() = catList.size

    //This is used to bind each data to each layout views
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        //The holder parameter stores our previously created ViewHolder
        //The holder.bindData function is declared in the CatViewHolder
        holder.bindData(catList[position])
    }
}