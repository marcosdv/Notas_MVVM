package br.com.marcosdiasvendramini.notas_mvvm.model

class GestorDeNotas(val database: Database) {

    fun getNotas() = database.obterNotas()

    fun addNota(nota: Nota) {
        database.inserirNota(nota)
    }
}