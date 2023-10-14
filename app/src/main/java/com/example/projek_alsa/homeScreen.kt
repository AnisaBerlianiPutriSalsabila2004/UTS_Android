package com.example.projek_alsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_alsa.databinding.ActivityHomeScreenBinding

class homeScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: ArrayList<film>
    private lateinit var movieAdapter: adapterFilm
    private lateinit var deskripsi: Array<String>
    private lateinit var binding:ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        deskripsi = resources.getStringArray(R.array.list_deskripsi)

        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.layoutManager = GridLayoutManager(this, 2)

        movieList = ArrayList()

        movieList.add(film(R.drawable.img1, R.drawable.bg_1, "Girly, Comedy, Politics", "Barbie", "Greta Gerwig", R.drawable.rate5, "5",  deskripsi[0], "1h 54m", "R17+"))
        movieList.add(film(R.drawable.img2, R.drawable.bg_2,"Action, Sci Fi, Racing","Fast X", "Louis Leterrier", R.drawable.rate5, "5", deskripsi[1], "2h 21m", "R18+"))
        movieList.add(film(R.drawable.img3, R.drawable.bg_3,"Romance, Drama", "Ketika Berhenti Disini","Umay Shahab", R.drawable.rate3, "3", deskripsi[2], "1h 42m", "R15+"))
        movieList.add(film(R.drawable.img4, R.drawable.bg_4, "Family, Adventure","Petualngan Sherina 2", "Riri Riza", R.drawable.rate5, "5", deskripsi[3], "2h 6m", "R7+"))
        movieList.add(film(R.drawable.img5, R.drawable.bg_5, "Comedy, Family","The Super Mario bros", "Aaron Horvath", R.drawable.rate4, "4",  deskripsi[4], "1h 32m", "R10+"))
        movieList.add(film(R.drawable.img6, R.drawable.bg_6, "Action, Fighting, Anime","Kiko the Series", "sunghoo park", R.drawable.rate5, "5", deskripsi[5], "1h 45m", "R13+"))

        movieAdapter = adapterFilm(movieList)
        binding.recycleView.adapter = movieAdapter

        val name = intent.getStringExtra(loginPage.names)
        binding.username.text = name

        with(binding){
            movieAdapter.onItemClick = {
                val intentToDescription = Intent(this@homeScreen, filmDescription::class.java)
                intentToDescription.putExtra("film", it)
                startActivity(intentToDescription)
            }
        }
    }
}