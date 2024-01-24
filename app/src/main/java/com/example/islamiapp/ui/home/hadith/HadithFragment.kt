package com.example.islamiapp.ui.home.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadithBinding
import com.example.islamiapp.model.Hadith
import com.example.islamiapp.ui.soraDetails.HadithRecyclerAdapter


class HadithFragment: Fragment()  {
    private lateinit var viewBinding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding= FragmentHadithBinding.inflate(inflater,container,false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadithFile()
    }
    val hadithList= mutableListOf<Hadith>()
    fun readHadithFile(){

        val inputStream =context?.assets?.open("ahadeeth.txt")
        val fileContent= inputStream?.bufferedReader().use { it?.readText() }
        val allAhadith=fileContent?.trim()?.split("#")
        allAhadith?.forEach{hadith->
            val lines= hadith.trim().split("\n")
            val newList=lines.toMutableList().apply {
                removeAt(0)
            }
            val title=lines[0]
            val content=newList.joinToString("\n")
            val hadith=Hadith(title,content)
            hadithList.add(hadith)
        }
        showHadithList(hadithList)
    }
    val hadapter=HadithRecyclerAdapter(hadithList)
    fun showHadithList(hadithList:MutableList<Hadith>){
        viewBinding.rvHadiith.adapter=hadapter

    }
}