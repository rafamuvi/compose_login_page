package br.com.rafamuvi.compose_login_page

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rafamuvi.compose_login_page.navigation.SetupNavGraph
import br.com.rafamuvi.compose_login_page.screens.LoginPage


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()
            SetupNavGraph(navController = navController)

        }
    }
}