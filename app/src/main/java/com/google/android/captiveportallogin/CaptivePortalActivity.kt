package com.google.android.captiveportallogin

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.content.Intent
import android.util.Log

class CaptivePortalActivity : Activity() {
override fun onCreate(savedInstanceState: Bundle?){
setTheme(android.R.style.Theme_NoTitleBar_Fullscreen)

super.onCreate(savedInstanceState)

val webView = WebView(this)

webView.webViewClient = WebViewClient()

webView.settings.javaScriptEnabled = true
webView.settings.allowFileAccess = false

setContentView(webView)

val captivePortalUrl = intent.dataString?: intent.getStringExtra("android.net.extra.CAPTIVE_PORTAL_URL")

if (captivePortalUrl != null) {
webView.loadUrl(captivePortalUrl)

} else {
Log.d("CaptivePortalActivity", "Captive Portal URL not found. Please contact your network administrator.")

}


}

}
