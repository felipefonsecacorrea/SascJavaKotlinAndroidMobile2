package com.senai.vsconnect_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.senai.vsconnect_kotlin.R
import com.senai.vsconnect_kotlin.models.Equipamento
import com.senai.vsconnect_kotlin.models.Servico

class ListaServicoAdapter(
    private val context: Context,
    private val listaEquipamento: List<Equipamento>
) : RecyclerView.Adapter<ListaServicoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //Essa função é responsável por chamar e atribuir valores para as views do item da RecyclerView
        fun vincularDadosNoItem(equipamento: Equipamento) {
            val txtmodelo = itemView.findViewById<TextView>(R.id.modeloEquipamento)
            txtmodelo.text = equipamento.modelo.modelo

            val txtfabricante = itemView.findViewById<TextView>(R.id.fabricanteEquipamento)
            txtfabricante.text = equipamento.modelo.fabricante.titulo

            val txtsetor = itemView.findViewById<TextView>(R.id.setorEquipamento)
            txtsetor.text = equipamento.setor.titulo

            val txtconsumo = itemView.findViewById<TextView>(R.id.consumoEquipamento)
            txtconsumo.text = equipamento.modelo.consumo_nominal.toString()

            val txtid = itemView.findViewById<TextView>(R.id.idEquipamento)
            txtid.text = equipamento.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaServicoAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context);

        val view = inflater.inflate(R.layout.fragment_servico, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaServicoAdapter.ViewHolder, position: Int) {
        val itemEquipamento = listaEquipamento[position]

        holder.vincularDadosNoItem(itemEquipamento)
    }

    override fun getItemCount(): Int {
        return listaEquipamento.size
    }
}