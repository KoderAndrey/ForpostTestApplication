package com.forpost.testapp

import android.app.Application
import com.forpost.testapp.domain.di.AppInjector

class UserApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.setup()
    }
}