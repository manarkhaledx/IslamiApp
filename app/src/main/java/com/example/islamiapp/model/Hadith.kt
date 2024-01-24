package com.example.islamiapp.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize

@Parcelize
class Hadith(val title:String,val content:String) : Parcelable {
}