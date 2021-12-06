package br.com.rafamuvi.compose_login_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rafamuvi.compose_login_page.ui.theme.MyPinky
import br.com.rafamuvi.compose_login_page.ui.theme.MyPurple
import br.com.rafamuvi.compose_login_page.ui.theme.Purple200
import compose_login_page.R

@Composable
fun LoginPage() {

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
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog_logo),
                contentDescription = "Dog looking to the screen",
                modifier = Modifier
                    .size(258.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(color = Color(0xFF00B7FF), text = "Log In") {

            }
            Spacer(modifier = Modifier.padding(10.dp))
            LoginButton(color = Color(0xFF0088FF), text = "Sign Up") {

            }
        }
    }
}

@Composable
fun LoginButton(
    color: Color,
    text: String,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 80.dp),
        shape = RoundedCornerShape(50),
        onClick = onClick
    ) {
        Text(
            text = text,
            style = TextStyle(color = Color.White),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    //SplashScreen()
    LoginPage()
}