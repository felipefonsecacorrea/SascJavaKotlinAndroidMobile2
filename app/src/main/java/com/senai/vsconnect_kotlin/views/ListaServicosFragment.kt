package com.senai.vsconnect_kotlin.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.senai.vsconnect_kotlin.R
import com.senai.vsconnect_kotlin.adapters.ListaServicoAdapter
import com.senai.vsconnect_kotlin.apis.EndpointInterface
import com.senai.vsconnect_kotlin.apis.RetrofitConfig
import com.senai.vsconnect_kotlin.databinding.FragmentEditarImagemBinding
import com.senai.vsconnect_kotlin.databinding.FragmentListaServicosBinding
import com.senai.vsconnect_kotlin.models.Equipamento
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaServicosFragment : Fragment() {

        private var _binding: FragmentListaServicosBinding? = null
        private val binding get() = _binding!!

        private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

        private val endpoints = clienteRetrofit.create(EndpointInterface::class.java)

        private fun setContentView(activityMain: Int) {

        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            _binding = FragmentListaServicosBinding.inflate(inflater, container, false)

            val root: View = binding.root

            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_lista_servicos)

            // organiza os itens da Recycler em ordem vertical, sendo um debaixo do outro
            binding.recyclerEquipamento.layoutManager = LinearLayoutManager(requireContext())

            endpoints.listarEquipamento().enqueue(object : Callback<List<Equipamento>> {
                override fun onResponse(call: Call<List<Equipamento>>, response: Response<List<Equipamento>>) {
                    val servicos = response.body()

                    binding.recyclerEquipamento.adapter = servicos?.let { ListaServicoAdapter(requireContext(), it) }
                }

                override fun onFailure(call: Call<List<Equipamento>>, t: Throwable) {
                    println("Falha na requisição: ${t.message}")
                }

            })

            return root
        }
    }