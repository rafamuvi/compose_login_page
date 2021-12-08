package br.com.rafamuvi.compose_login_page.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.rafamuvi.compose_login_page.screens.LoginPage
import br.com.rafamuvi.compose_login_page.screens.LoginScreen
import br.com.rafamuvi.compose_login_page.screens.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginPage(navController = navController)
        }
        composable(route = Screen.LoginInput.route) {
            LoginScreen(navController = navController)
        }
    }
}