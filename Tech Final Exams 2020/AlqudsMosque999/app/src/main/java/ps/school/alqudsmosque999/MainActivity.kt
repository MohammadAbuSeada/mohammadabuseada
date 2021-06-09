package ps.school.alqudsmosque999

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mosque_btn.setOnClickListener {
            val intent = Intent(this, MosqueShow::class.java)
            startActivity(intent)
        }

        website_btn.setOnClickListener {
            val intent = Intent(this, MosqueSite::class.java)
            startActivity(intent)
        }

        video_btn.setOnClickListener {
            val intent = Intent(this, MosqueVedio::class.java)
            startActivity(intent)
        }
    }
}