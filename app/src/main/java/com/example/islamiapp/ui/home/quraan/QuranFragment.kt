package com.example.islamiapp.ui.home.quraan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentQuraanBinding
import com.example.islamiapp.ui.Constants
import com.example.islamiapp.ui.soraDetails.SoraDetailsActivity

class QuranFragment: Fragment()  {
    private lateinit var viewBinding: FragmentQuraanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentQuraanBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    val sora= listOf("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
        ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
        ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
        ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
        ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
        ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
        ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
        ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس")
    private lateinit var rvadapter: SoraRecyclerAdapter
    private fun initRecycler() {

        rvadapter= SoraRecyclerAdapter(sora)


        viewBinding.rvSora.apply {
            adapter=rvadapter
        }
//
        rvadapter.onItemClickListener= SoraRecyclerAdapter.OnItemClickListener { item, position ->
            showSuraDetailsActivity(item, position)
        }


    }

    private fun showSuraDetailsActivity(title: String, position: Int) {
        val intent = Intent(activity, SoraDetailsActivity::class.java)

        intent.putExtra(Constants.ChapterIndex,position+1)
        intent.putExtra(Constants.ChapterTitle,title)
        startActivity(intent)
    }
}