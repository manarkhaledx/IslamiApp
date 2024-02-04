package com.example.islamiapp.ui.soraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivitySoraDetailsBinding
import com.example.islamiapp.ui.Constants

class SoraDetailsActivity : AppCompatActivity() {
    var soraIndex:Int=0
    lateinit var soraTitle:String
    lateinit var viewBinding:ActivitySoraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivitySoraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBarSora)
        soraIndex=intent.getIntExtra(Constants.ChapterIndex,0)
        soraTitle=intent.getStringExtra(Constants.ChapterTitle)?:""
        initViews()
        readSoraFile()
    }

    private fun initViews() {
        viewBinding.apply {
            tvSoraTitles.text=soraTitle

        }
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun readSoraFile()
    {
       val inputStream= assets.open("$soraIndex.txt")
       val fileContent= inputStream.bufferedReader().use { it.readText() }
        val lines=fileContent.trim().split("\n")
        initRecyclerView(lines)
    }

    private fun initRecyclerView(verses: List<String>) {
        val versadapter=VersesRecyclerAdapter(verses)
        viewBinding.soraContent.rvDetailsSora.adapter=versadapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}