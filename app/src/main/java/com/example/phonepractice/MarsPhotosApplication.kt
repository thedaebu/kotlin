package com.example.phonepractice

import android.app.Application
import com.example.phonepractice.data.AppContainer
import com.example.phonepractice.data.DefaultAppContainer

class MarsPhotosApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
