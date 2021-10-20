package bahrudin.bagus.submitilham

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingsubmission.ListFighterAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvFighter: RecyclerView
    private var list: ArrayList<Fighter> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "UFC Lightweight Rankings"

        rvFighter = findViewById(R.id.rv_fighter)
        rvFighter.setHasFixedSize(true)

        list.addAll(FighterData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvFighter.layoutManager = LinearLayoutManager(this)
        val listFighterAdapter = ListFighterAdapter(list)
        rvFighter.adapter = listFighterAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.icon_about -> {
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}