package com.example.pracrecyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pracrecyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paletteList = arrayListOf(
            Palettes("cozy", arrayListOf(Colors("pink", R.drawable.pink), Colors("blue", R.drawable.blue)) ),
            Palettes("lazy", arrayListOf(Colors("purple", R.drawable.purple), Colors("red", R.drawable.red)) )
        )

        binding.rvPalette.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPalette.setHasFixedSize(true)

        binding.rvPalette.adapter = PaletteAdapter(paletteList)
    }
}