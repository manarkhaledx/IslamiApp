package com.example.islamiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.ActivityMainBinding
import com.example.islamiapp.ui.home.hadith.HadithFragment
import com.example.islamiapp.ui.home.quraan.QuranFragment
import com.example.islamiapp.ui.home.radio.RadioFragment
import com.example.islamiapp.ui.home.sebha.SebhaFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews(){
        viewBinding.content.bottomNav.setOnItemSelectedListener { item ->
           val fragment:Fragment= when (item.itemId) {
                R.id.nav_quraan -> {
                    QuranFragment()
                }

                R.id.nav_hadith -> {
                   HadithFragment()
                }

                R.id.nav_radio -> {
                    RadioFragment()
                }

                R.id.nav_sebha -> {
                    SebhaFragment()
                }else->{
                    QuranFragment()
                }
            }
            true //ITEM SELECTED
        }
        viewBinding.content.bottomNav.selectedItemId=R.id.nav_quraan
    }
    /*WithoutLambda
    *  private fun initViews(){
        viewBinding.content.bottomNav.setOnItemSelectedListener(object : OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.nav_quraan->{

                    } R.id.nav_hadith->{

                }
                    R.id.nav_radio->{

                    }
                    R.id.nav_sebha->{

                    }
                }
                return true //ITEM SELECTED
            }
        })*/

   /* replaced by above
   private fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }*/
}