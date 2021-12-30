package br.com.marcosdiasvendramini.notas_mvvm.di

import br.com.marcosdiasvendramini.notas_mvvm.model.Database
import br.com.marcosdiasvendramini.notas_mvvm.model.GestorDeNotas
import br.com.marcosdiasvendramini.notas_mvvm.viewmodel.NotasViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ModulosDeDependencias {
    val moduloApp = module {
        single { Database() }

        factory { GestorDeNotas(get()) }

        viewModel { NotasViewModel(get()) }
    }
}