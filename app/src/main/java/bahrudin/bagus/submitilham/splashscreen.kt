package bahrudin.bagus.submitilham

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class splashscreen : AppCompatActivity() {
    @Suppress("DEPRECATION") // jika ini dihilangkan maka Handler() deprecated
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalshscreen)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@splashscreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}
