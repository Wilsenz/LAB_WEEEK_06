package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(itemView) {

    // 1. Dapatkan referensi ke semua View dari layout item Anda
    private val catNameView: TextView = itemView.findViewById(R.id.cat_name) // Ganti ID jika berbeda
    private val catBreedView: TextView = itemView.findViewById(R.id.cat_breed) // Ganti ID jika berbeda
    private val catPhotoView: ImageView = itemView.findViewById(R.id.cat_photo) // Ganti ID jika berbeda
    // Tambahkan view lain jika ada (misal: gender, biografi)

    fun bindData(cat: CatModel) {
        // 2. Set data teks ke TextViews
        catNameView.text = cat.name
        catBreedView.text = cat.breed.name
        // set view lainnya...

        // 3. (INI BAGIAN PENTING) Panggil imageLoader untuk memuat gambar
        imageLoader.loadImage(cat.imageUrl, catPhotoView)

        // 4. Atur OnClickListener untuk item
        itemView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
    }
}
