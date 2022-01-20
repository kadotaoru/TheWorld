package to.msn.wings.theworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class OpeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "クリックされました。", Toast.LENGTH_SHORT).show()
        }
    }
}