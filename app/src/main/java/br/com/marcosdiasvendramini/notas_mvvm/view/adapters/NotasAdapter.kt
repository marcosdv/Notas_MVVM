package br.com.marcosdiasvendramini.notas_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.marcosdiasvendramini.notas_mvvm.model.Nota

class NotasViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindView(item: Nota) {
        with(view) {
            val txtNota: TextView = view.findViewById(R.id.txt_nota)
            txtNota.text = item.text
        }
    }
}

class NotasAdapter(val data: MutableList<Nota> = mutableListOf()): RecyclerView.Adapter<NotasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotasViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) =
        holder.bindView(data[position])

    override fun getItemCount(): Int = data.size

    fun add(item: Nota) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Nota>) {
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Nota) {
        data.remove(item)
        notifyDataSetChanged()
    }
}