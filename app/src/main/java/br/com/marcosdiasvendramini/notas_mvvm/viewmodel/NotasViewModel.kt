package br.com.marcosdiasvendramini.notas_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marcosdiasvendramini.notas_mvvm.model.Database
import br.com.marcosdiasvendramini.notas_mvvm.model.GestorDeNotas
import br.com.marcosdiasvendramini.notas_mvvm.model.Nota

class NotasViewModel(val gestorNotas: GestorDeNotas): ViewModel() {

    private var mNotas: MutableLiveData<MutableList<Nota>>? = null

    fun getNotas(): LiveData<MutableList<Nota>> {
        if (mNotas == null) {
            mNotas = gestorNotas.getNotas()
        }
        return mNotas!!
    }

    fun salvar(text: String) {
        val nota = Nota(id = 6, text = text)
        gestorNotas.addNota(nota)
    }
}