package br.com.rafamuvi.compose_login_page.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Login : Screen("login_page")
    object LoginInput : Screen("login_screen")
}
