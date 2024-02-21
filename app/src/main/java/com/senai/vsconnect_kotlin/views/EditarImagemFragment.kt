package com.senai.vsconnect_kotlin.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment
import com.senai.vsconnect_kotlin.R
import com.senai.vsconnect_kotlin.apis.EndpointInterface
import com.senai.vsconnect_kotlin.apis.RetrofitConfig
import com.senai.vsconnect_kotlin.databinding.FragmentEditarImagemBinding
import java.util.*

class EditarImagemFragment : Fragment() {

    private var _binding: FragmentEditarImagemBinding? = null
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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _binding = FragmentEditarImagemBinding.inflate(inflater, container, false)

        val root: View = binding.root


        val butaozao : Button = root.findViewById(R.id.button)

        butaozao.setOnClickListener {

            // Carrega o link do Power BI no WebView
            val powerBiLink = "https://app.powerbi.com/links/tM5TVOqdEJ?ctid=79553679-86d7-4827-88ba-d5dd74a01773&pbi_source=linkShare&bookmarkGuid=371c1003-5ca0-41fa-a4ab-4cc5c25c708d"

//            val powerBiLink = "com.microsoft.powerbimobile"
//

            val intent = Intent( Intent.ACTION_VIEW, Uri.parse(powerBiLink))
            startActivity(intent)


            // Adicionar a categoria CATEGORY_BROWSABLE para especificar o Chrome como o navegador preferido
            intent.addCategory(Intent.CATEGORY_BROWSABLE)

            // Adicionar a categoria CATEGORY_APP_BROWSER para especificar o Chrome como o navegador preferido
            intent.addCategory(Intent.CATEGORY_APP_BROWSER)

            // Verificar se há algum aplicativo disponível para lidar com a Intent
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                // Abrir o navegador com a URL especificada
                startActivity(intent)
            } else {
                // Se não houver nenhum aplicativo disponível para lidar com a Intent
                // Exibir uma mensagem de erro ou fazer outra ação, se necessário
            }
        }

//        webView.loadUrl(powerBiLink)



//        val webView: WebView = root.findViewById(R.id.webCads)
//        webView.settings.javaScriptEnabled = true
//
//
//
//        // Configura um WebViewClient para navegação dentro do WebView
//        webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url.toString())
//                return true
//            }
//        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}

//        val myWebView: WebView = root.findViewById(R.id.webBi)
//        myWebView.loadUrl("https://app.powerbi.com/groups/me/reports/c563524e-8858-4be8-bff1-bbd43afbb4d9?ctid=79553679-86d7-4827-88ba-d5dd74a01773&pbi_source=linkShare")

//        val unencodedHtml = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cHIiD5xv7UA?si=mhW8jECJ6o6qmfnE\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";

//
//        myWebView.loadData(unencodedHtml, "text/html", "UTF-8")
//
//        val encodedHtml = Base64.getEncoder().encodeToString(unencodedHtml.toByteArray())
//
//
//        myWebView.settings.javaScriptEnabled
//        myWebView.settings.javaScriptCanOpenWindowsAutomatically
//        myWebView.settings.allowContentAccess
