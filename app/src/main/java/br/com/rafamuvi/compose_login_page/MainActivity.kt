package br.com.rafamuvi.compose_login_page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //SplashScreen()
            LoginPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview(){
    //SplashScreen()
    LoginPage()
}
