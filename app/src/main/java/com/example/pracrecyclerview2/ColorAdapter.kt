package com.example.pracrecyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pracrecyclerview2.databinding.ItemColorBinding
import java.util.*
import kotlin.collections.ArrayList

class ColorAdapter(val colorList: ArrayList<Colors>) : RecyclerView.Adapter<ColorAdapter.CustomViewHolder>() {

    fun removeData(position: Int){
        colorList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addData(color: String, color_img: Int){
        colorList.add(Colors(color, color_img))
        notifyItemInserted(colorList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return CustomViewHolder(ItemColorBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(colorList[position])
    }

    override fun getItemCount(): Int = colorList.size

    class CustomViewHolder(val binding: ItemColorBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(color: Colors) = with(binding){
            ivColorImg.setImageResource(color.color_img)
            tvColor.text = color.color
        }
    }
}