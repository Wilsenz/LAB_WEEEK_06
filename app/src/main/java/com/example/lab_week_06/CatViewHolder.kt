package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender // Pastikan Gender di-import

class CatViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener // Menggunakan OnClickListener dari Adapter
) : RecyclerView.ViewHolder(itemView) {

    // 1. Dapatkan referensi ke semua View dari layout Anda
    private val catNameView: TextView = itemView.findViewById(R.id.cat_name)
    private val catBreedView: TextView = itemView.findViewById(R.id.cat_breed)
    private val catPhotoView: ImageView = itemView.findViewById(R.id.cat_photo)
    // PERBAIKAN: Tambahkan referensi untuk TextView gender
    private val catGenderView: TextView = itemView.findViewById(R.id.cat_gender) // Ganti R.id.cat_gender dengan ID Anda

    fun bindData(cat: CatModel) {
        // Set data teks yang sudah ada
        catNameView.text = cat.name
        catBreedView.text = cat.breed.name // Menggunakan .name dari objek CatBreed

        // PERBAIKAN: Tambahkan logika untuk menampilkan gender
        catGenderView.text = when (cat.gender) {
            Gender.Male -> "♂ Male"
            Gender.Female -> "♀ Female"
            Gender.Unknown -> "Unknown"
        }

        // Panggil imageLoader untuk memuat gambar
        imageLoader.loadImage(cat.imageUrl, catPhotoView)

        // Atur OnClickListener untuk item
        itemView.setOnClickListener {
            onClickListener.onItemClick(cat) // Pastikan nama fungsinya cocok dengan interface
        }
    }
}
