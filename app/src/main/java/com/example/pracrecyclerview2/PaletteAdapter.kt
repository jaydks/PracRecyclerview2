package com.example.pracrecyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pracrecyclerview2.databinding.ItemPaletteBinding

class PaletteAdapter(val paletteList: ArrayList<Palettes>) : RecyclerView.Adapter<PaletteAdapter.CustomViewHolder>()
{
    //private val paletteList : ArrayList<Palettes> = arrayListOf()

    fun removeData(position: Int){
        paletteList.removeAt(position)
        notifyItemRemoved(position)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaletteAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_palette, parent, false)
        return CustomViewHolder(ItemPaletteBinding.bind(view))
    }

    override fun onBindViewHolder(holder: PaletteAdapter.CustomViewHolder, position: Int) {
        holder.bind(paletteList[position])
    }

    override fun getItemCount(): Int = paletteList.size

    class CustomViewHolder(val binding: ItemPaletteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(palette: Palettes) = with(binding){
            val colorlist = palette.colors
            tvPalette.text = palette.name
            binding.rvColor.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvColor.setHasFixedSize(true)
            binding.rvColor.adapter = ColorAdapter(colorlist)
        }
    }
}