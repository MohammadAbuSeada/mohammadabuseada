package ps.school.alqudsmosque999

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_mosque_site.*

class MosqueSite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mosque_site)

        loadURL()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun loadURL(){
        webview.loadUrl("http://info.wafa.ps/ar page.aspx?id=9655")
        webview.settings.javaScriptEnabled = true
        webview.settings.loadsImagesAutomatically = true

        webview.webViewClient= WebViewClient()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}