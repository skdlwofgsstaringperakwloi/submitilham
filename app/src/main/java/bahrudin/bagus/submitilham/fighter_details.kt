package bahrudin.bagus.submitilham

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class fighter_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fighter_details)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Fighter"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_name)
        val imgSetPhoto: ImageView = findViewById(R.id.foto)
        val tvSetIden: TextView = findViewById(R.id.tv_identitas)
        val tvOverview: TextView = findViewById(R.id.tv_deskripsi)
        val tvRank: TextView = findViewById(R.id.tv_rank)

        val tName  = intent.getStringExtra(EXTRA_NAMA)
        val tImg = intent.getStringExtra(EXTRA_FOTO)
        val tIden = intent.getStringExtra(EXTRA_IDENTITAS)
        val tOverview = intent.getStringExtra(EXTRA_DESKRIPSI)
        val tRank = intent.getStringExtra(EXTRA_RANKING)

        tvSetName.text = tName

        // menggunakan library Glide untuk request gambar
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)


        tvSetIden.text = tIden
        tvOverview.text = tOverview
        tvRank.text = tRank
    }

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_FOTO = "extra_foto"
        const val EXTRA_IDENTITAS = "extra_identitas"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
        const val EXTRA_RANKING = "extra_ranking"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}