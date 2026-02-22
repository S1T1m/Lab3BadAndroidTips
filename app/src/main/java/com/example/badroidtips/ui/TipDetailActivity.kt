package com.example.badroidtips.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.badroidtips.R

class TipDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_detail)

        val day = intent.getIntExtra(EXTRA_DAY, 1)
        val title = intent.getStringExtra(EXTRA_TITLE).orEmpty()
        val full = intent.getStringExtra(EXTRA_FULL).orEmpty()
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)

        findViewById<ImageView>(R.id.detailImage).setImageResource(image)
        findViewById<TextView>(R.id.detailTitle).text = getString(R.string.day_title_format, day, title)
        findViewById<TextView>(R.id.detailText).text = full
    }

    companion object {
        const val EXTRA_DAY = "extra_day"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_FULL = "extra_full"
        const val EXTRA_IMAGE = "extra_image"
    }
}
