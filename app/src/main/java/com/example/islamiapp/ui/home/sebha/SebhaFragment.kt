package com.example.islamiapp.ui.home.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment:Fragment() {
    private lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding= FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tsbeehList: MutableList<String> = mutableListOf("سبحان الله", "الحمد الله", "الله أكبر")
        var currentRotation = 0f
        var tsbeehCounter:Int=0
        var tsbeehpos=0
        viewBinding.sebhaDuaa.setOnClickListener {
            currentRotation +=30f
            viewBinding.imgSeb7aBody.rotation = currentRotation
            if (tsbeehCounter < 33)
                tsbeehCounter++
            else {
                tsbeehCounter = 0
                tsbeehpos =
                    if (tsbeehpos < tsbeehList.size - 1) ++tsbeehpos else 0
                viewBinding.sebhaDuaa.text = tsbeehList[tsbeehpos]
            }
            viewBinding.tvSebhaCounter.text = tsbeehCounter.toString()

        }

    }
}