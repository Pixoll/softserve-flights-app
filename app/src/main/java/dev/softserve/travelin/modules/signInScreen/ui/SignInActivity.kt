package dev.softserve.travelin.modules.signInScreen.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.softserve.travelin.ui.theme.TravelinTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignInScreen(
                        modifier = Modifier.padding(innerPadding)//.fillMaxSize()
                    )
                    SocialButton(
                        modifier = Modifier.padding(innerPadding),
                        text = "Google",
                        backgroundColor = Color.White,
                        textColor = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    // Para simular la entrada de texto:
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Colores de ejemplo
    val backgroundColor = Color(0xFF009688) // Turquesa aproximado
    val buttonColor = Color(0xFF00796B)     // Verde más oscuro
    val textColor = Color.White

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Podemos usar una columna para centrar el contenido verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título principal
            Text(
                text = "Let's Travel you in.",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Subtítulo
            Text(
                text = "Discover the World with Every Sign In",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Campo de texto para Email/Phone
            OutlinedTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                label = { Text("Email or Phone Number") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) {
                        painterResource(id = android.R.drawable.ic_menu_view)
                    } else {
                        painterResource(id = android.R.drawable.ic_lock_idle_lock)
                    }
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = "Toggle password visibility",
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            // Enlace para "Forgot password?"
            TextButton(
                onClick = { /* Aquí irá la acción de 'olvidó contraseña' */ },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 16.dp, top = 8.dp)
            ) {
                Text(
                    text = "Forgot password?",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Sign In
            Button(
                onClick = { /* Acción de Sign In */ },
                colors = ButtonDefaults.buttonColors(buttonColor),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Sign In",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de "o inicia sesión con"
            Text(
                text = "or sign in with",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones/íconos para Google, Apple, Facebook
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButton(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "Google",
                    backgroundColor = Color.White,
                    textColor = Color.Gray
                )
                SocialButton(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "Apple",
                    backgroundColor = Color.Black,
                    textColor = Color.White
                )
                SocialButton(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Facebook",
                    backgroundColor = Color(0xFF4267B2),
                    textColor = Color.White
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de Sign Up
            TextButton(
                onClick = { /* Acción para ir a Sign Up */ }
            ) {
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    textColor: Color
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    TravelinTheme {
        SignInScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SocialButtonPreview() {
    TravelinTheme {
        SocialButton(
            text = "Google",
            backgroundColor = Color.White,
            textColor = Color.Gray
        )
    }
}



