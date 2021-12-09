package br.com.rafamuvi.compose_login_page.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.rafamuvi.compose_login_page.ui.theme.MyPinky
import br.com.rafamuvi.compose_login_page.ui.theme.MyPurple
import br.com.rafamuvi.compose_login_page.ui.theme.Purple200

@Composable
fun ForgotPassScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        MyPinky,
                        MyPurple,
                        Purple200
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Forgot Password Screen", style = TextStyle(fontSize = 30.sp))
        }
    }
}
