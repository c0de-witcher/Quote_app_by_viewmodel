package com.example.quote_app

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class viewmodel_factory(var context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return mainview_model(context) as T;
    }

}