package br.com.marcosdiasvendramini.notas_mvvm

import android.app.Application
import br.com.marcosdiasvendramini.notas_mvvm.di.ModulosDeDependencias
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        var app = startKoin {
            modules(ModulosDeDependencias.moduloApp)
        }
    }
}