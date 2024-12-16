package com.example.pruebatecnica

import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val URL_BASE: String = resources.getString(R.string.url_app_web_init)
        val objWebView: WebView = findViewById(R.id.webView)

        objWebView.webChromeClient = object : WebChromeClient(){

        }

        objWebView.webViewClient = object : WebViewClient(){

        }

        CookieManager.getInstance().setAcceptCookie(true)

        val setting: WebSettings = objWebView.settings
        setting.javaScriptEnabled = true
        setting.domStorageEnabled = true

        objWebView.loadUrl(URL_BASE)

    }

    override fun onBackPressed() {
        val objWebView: WebView = findViewById(R.id.webView)
        if(objWebView.canGoBack()) {
            objWebView.goBack()
            return;
        }
        super.onBackPressed()
    }
}