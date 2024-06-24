package com.example.quote_app

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class mainview_model(@SuppressLint("StaticFieldLeak") var context : Context): ViewModel() {
     var arrayofquotes : Array<quotes> = emptyArray();
    var index =0;
    init {
        arrayofquotes = loadQuotes();
    }

    fun loadQuotes():Array<quotes>{
        return try {var inputstream = context.assets.open("quotes.json")
        val size = inputstream.available(); //give the size of file
        val buffer = ByteArray(size)
        inputstream.read(buffer)
        inputstream.close()
        val json = String(buffer, charset("UTF-8"))
        val gson = Gson()
         gson.fromJson(json,Array<quotes>::class.java)}
        catch (e: Exception) {
            e.printStackTrace()
            emptyArray()
        }


    }

    fun getquote() = arrayofquotes[index]
    fun nextquote() = arrayofquotes[++index]
    fun previousquote() = arrayofquotes[--index]



}