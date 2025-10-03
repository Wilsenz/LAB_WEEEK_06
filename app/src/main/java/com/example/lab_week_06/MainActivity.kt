package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {
    // ... (properti lain seperti recyclerView dan catAdapter tidak perlu diubah) ...
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener {
            // Pastikan nama fungsi ini konsisten dengan interface di CatAdapter
            // Jika error, ganti ke 'onClick' atau sebaliknya.
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Panggil fungsi untuk mengisi data
        loadCatData()
    }

    // Fungsi baru untuk memuat data kucing
    private fun loadCatData() {
        // PERBAIKAN: Menggunakan URL yang sudah diverifikasi menunjuk langsung ke file gambar.
        val cats = listOf(
            CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Unknown, CatBreed.AmericanCurl, "George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
            CatModel(Gender.Male, CatBreed.Bengal, "Simba", "Loves to roar", "https://cdn2.thecatapi.com/images/j6oFGLpRG.jpg"),
            CatModel(Gender.Female, CatBreed.Persian, "Cleo", "Queen of the house", "https://cdn2.thecatapi.com/images/4RzEwvyzz.jpg"), // URL Diperbarui
            CatModel(Gender.Male, CatBreed.Siamese, "Sam", "Very vocal and demanding", "https://cdn2.thecatapi.com/images/ai6Jps4sx.jpg"),
            CatModel(Gender.Female, CatBreed.Sphynx, "Naked", "Needs a sweater", "https://cdn2.thecatapi.com/images/t2hN_g2aG.jpg"), // URL Diperbarui
            CatModel(Gender.Male, CatBreed.Oriental, "Shadow", "Sleek and mysterious", "https://cdn2.thecatapi.com/images/8pCFG7gCV.jpg"),
            CatModel(Gender.Female, CatBreed.Abyssinian, "Amber", "Active and playful", "https://cdn2.thecatapi.com/images/s75z4yI3i.jpg"), // URL Diperbarui
            CatModel(Gender.Male, CatBreed.Birman, "Milo", "Gentle and affectionate", "https://cdn2.thecatapi.com/images/4lXnnfxac.jpg")
        )
        catAdapter.setData(cats)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> /* Do nothing */ }
            .show()
    }
}

