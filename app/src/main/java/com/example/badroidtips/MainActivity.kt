package com.example.badroidtips

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.badroidtips.data.TipsList
import com.example.badroidtips.ui.TipAdapter
import com.example.badroidtips.ui.TipDetailActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tips = TipsList.getTips()
        val rv: RecyclerView = findViewById(R.id.tipsRecycler)

        rv.adapter = TipAdapter(tips) { tip ->
            val i = Intent(this, TipDetailActivity::class.java).apply {
                putExtra(TipDetailActivity.EXTRA_DAY, tip.day)
                putExtra(TipDetailActivity.EXTRA_TITLE, getString(tip.titleRes))
                putExtra(TipDetailActivity.EXTRA_FULL, getString(tip.fullTextRes))
                putExtra(TipDetailActivity.EXTRA_IMAGE, tip.imageRes)
            }
            startActivity(i)
        }
    }
}
