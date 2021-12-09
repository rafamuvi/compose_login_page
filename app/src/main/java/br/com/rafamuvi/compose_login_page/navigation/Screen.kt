package br.com.rafamuvi.compose_login_page.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Login : Screen("login_page")
    object SignUp : Screen("signup_screen")
    object Home : Screen("home_screen")
    object Forgot : Screen("forgot_screen")
}
