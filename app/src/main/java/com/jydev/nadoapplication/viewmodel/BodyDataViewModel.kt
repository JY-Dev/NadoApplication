package com.jydev.nadoapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jydev.nadoapplication.data.Body

class BodyDataViewModel : ViewModel() {
    private val bodyData = MutableLiveData<Body>()
    val body: LiveData<Body> get() = bodyData
    fun setBody(body: Body){
        bodyData.postValue(body)
    }

    fun getBody() : Body?{
        return body.value
    }
}