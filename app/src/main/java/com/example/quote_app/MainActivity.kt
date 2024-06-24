package com.example.quote_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    val quotetext: TextView
        get ()= findViewById<TextView>(R.id.Quote_text)
    val author : TextView
        get() = findViewById<TextView>(R.id.author)

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
      viewModel = ViewModelProvider(this,viewmodel_factory(applicationContext))[mainview_model::class.java] as mainview_model
        setquote((viewModel as mainview_model).getquote());
    }



    fun setquote(quote:quotes){
        quotetext.text   = quote.text;
        author.text   = quote.author;

    }

    fun onNext(view: View) {
        setquote((viewModel as mainview_model).nextquote())
    }
    fun onPrevious(view: View) {
        setquote((viewModel as mainview_model).previousquote())
    }
    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, (viewModel as mainview_model).getquote().text)
        startActivity(intent)
    }

}