package com.example.islamiapp.ui.home.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadithBinding


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
}