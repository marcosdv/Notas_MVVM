package br.com.marcosdiasvendramini.notas_mvvm.model

import androidx.lifecycle.MutableLiveData

class Database {
    private val mDataBase: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun inserirNota(nota: Nota) {
        var listaTemp = mDataBase.value
        if (listaTemp == null) {
            listaTemp = mutableListOf()
        }

        listaTemp!!.add(nota)
        mDataBase.postValue(listaTemp!!)
    }

    fun obterNotas() = mDataBase
}