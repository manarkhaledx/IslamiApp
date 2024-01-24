package com.example.islamiapp.ui.HadithDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHadithDetailsBinding
import com.example.islamiapp.model.Hadith
import com.example.islamiapp.ui.Constants

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadithDetailsBinding
    var hadith: Hadith? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadithDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        extractParam()
        initViews()

        setSupportActionBar(viewBinding.toolBarHadith)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        viewBinding.tvHadiithTitles.text = hadith?.title
        viewBinding.hadithContent.hadithContent.text = hadith?.content
        setTitle(null)
    }

    private fun extractParam() {
        hadith = intent.getParcelableExtra(Constants.HadithEXTRA)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
