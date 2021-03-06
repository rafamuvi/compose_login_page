package br.com.rafamuvi.compose_login_page.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.RelocationRequester
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.rafamuvi.compose_login_page.navigation.Screen
import br.com.rafamuvi.compose_login_page.ui.theme.MyPinky
import br.com.rafamuvi.compose_login_page.ui.theme.MyPurple
import br.com.rafamuvi.compose_login_page.ui.theme.Purple200
import compose_login_page.R

@ExperimentalComposeUiApi
@Composable
fun LoginPage(
    navController: NavController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
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
            Image(
                painter = painterResource(id = R.drawable.dog_logo),
                contentDescription = "Dog looking to the screen",
                modifier = Modifier
                    .padding(30.dp)
                    .size(129.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Card(
                modifier = Modifier
                    .weight(2f),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Welcome back!",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    UsernameField(keyboardController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    PasswordField(keyboardController)
                    Spacer(modifier = Modifier.padding(20.dp))
                    LoginButton(color = Color(0xFF00B7FF), text = "Log In") {
                        navController.navigate(route = Screen.Home.route) {
                            popUpTo("login_page") {
                                inclusive = true
                            }
                        }
                    }
                    Row {
                        CustomTextButton(text = "Sign Up") {
                            navController.navigate(route = Screen.SignUp.route) {
                                popUpTo("login_page") {
                                    inclusive = false
                                }
                            }
                        }
                        CustomTextButton(text = "Forgot Password?") {
                            navController.navigate(route = Screen.Forgot.route) {
                                popUpTo("login_page") {
                                    inclusive = false
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun UsernameField(keyboardController: SoftwareKeyboardController?) {
    var userText by remember { mutableStateOf("") }
    val relocationRequester = remember { RelocationRequester() }

    OutlinedTextField(
        value = userText,
        onValueChange = {
            userText = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .relocationRequester(relocationRequester),
        label = { Text(text = "Username") },
        shape = RoundedCornerShape(50),
        leadingIcon = { Icon(Icons.Default.AccountCircle, null) },
        trailingIcon = {
            IconButton(onClick = { userText = "" }) {
                Icon(Icons.Default.Close, null)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        )
    )
}

@ExperimentalComposeUiApi
@Composable
fun PasswordField(keyboardController: SoftwareKeyboardController?) {
    var passText by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }
    val relocationRequester = remember { RelocationRequester() }

    OutlinedTextField(
        value = passText,
        onValueChange = {
            passText = it
            relocationRequester.bringIntoView()
        },
        modifier = Modifier
            .fillMaxWidth()
            .relocationRequester(relocationRequester)
            .onFocusChanged { relocationRequester.bringIntoView() },
        label = { Text(text = "Password") },
        shape = RoundedCornerShape(50),
        leadingIcon = { Icon(Icons.Default.Lock, null) },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                if (isVisible) {
                    Icon(Icons.Default.Visibility, null)
                } else {
                    Icon(Icons.Default.VisibilityOff, null)
                }
            }
        },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        )
    )
}

@Composable
fun LoginButton(
    color: Color,
    text: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .fillMaxWidth(),
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

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,

    ) {

    TextButton(onClick = onClick) {
        Text(
            text = text,
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color(0, 154, 255, 255),
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline
            )
        )
    }

}


@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginPage(navController = rememberNavController())
}