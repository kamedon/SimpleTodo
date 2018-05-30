package com.kamedon.simpletodo

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class App : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        androidModule(this@App)
    }
}