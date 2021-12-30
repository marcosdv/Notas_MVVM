package br.com.marcosdiasvendramini.notas_mvvm.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import br.com.marcosdiasvendramini.notas_mvvm.NotasAdapter
import br.com.marcosdiasvendramini.notas_mvvm.R
import br.com.marcosdiasvendramini.notas_mvvm.viewmodel.NotasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val notasViewModel: NotasViewModel by viewModel()

    private val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = notasAdapter

        //inicializar o viewModel
        //notasViewModel = ViewModelProviders.of(this).get(NotasViewModel::class.java)

        notasViewModel.getNotas().observe(this, Observer { data ->
            //se a lista nao estiver nula, adiciona no adapter
            data?.let {
                if (it.isEmpty()) {
                    Toast.makeText(this, "Sem notas para exibir", Toast.LENGTH_LONG).show()
                }
                else {
                    notasAdapter.add(it)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_menu_adicionar) {
            dialogoAddNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogoAddNota() {
        var layout = LayoutInflater.from(this).inflate(R.layout.dialog_ui, null, false)

        var edtNota = layout.findViewById<EditText>(R.id.edt_nota)

        var dialogo = AlertDialog.Builder(this)
        dialogo.setView(layout)
        dialogo.setNegativeButton("Cancelar", null)
        dialogo.setPositiveButton("Salvar") { d, i ->
            notasViewModel.salvar(edtNota.text.toString())
        }
        dialogo.create().show()
    }
}