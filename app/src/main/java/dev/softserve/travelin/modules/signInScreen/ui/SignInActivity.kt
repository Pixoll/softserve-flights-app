package dev.softserve.travelin.modules.signInScreen.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import dev.softserve.travelin.R
import dev.softserve.travelin.ui.theme.TravelinTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelinTheme {
                // Scaffold para acomodar la UI general y padding interno
                Scaffold(modifier = Modifier.fillMaxSize()) { modifier ->
                    // SignInScreen(modifier = Modifier.padding(innerPadding))
                    SignInScreen(modifier = Modifier)
                }
            }
        }
    }
}

// Composable principal que orquesta la pantalla de Sign In
@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    // Variables para manejar el estado de los campos de texto
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Colores de ejemplo para la UI
    val backgroundColor = Color(0xFF009688) // Turquesa aproximado
    val buttonColor = Color(0xFF00796B)     // Verde más oscuro

    // Contenedor de fondo
    BackgroundContainer(modifier = modifier, backgroundColor = backgroundColor) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título principal
            TitleText(text = "Let's Travel you in.")
            // Subtítulo
            SubtitleText(text = "Discover the World with Every Sign In")
            // Campo para Email o Phone
            EmailField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Campo para Password
            PasswordField(
                password = password,
                onPasswordChange = { password = it },
                passwordVisible = passwordVisible,
                onTogglePasswordVisibility = { passwordVisible = !passwordVisible }
            )
            // Enlace "Forgot password?"
            ForgotPasswordButton(onClick = { /* Acción para 'Forgot password?' */ })
            Spacer(modifier = Modifier.height(16.dp))
            // Botón de Sign In
            SignInButton(
                text = "Sign In",
                buttonColor = buttonColor,
                onClick = { /* Acción para Sign In */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Texto para separar inicio de sesión social
            SocialLoginText(text = "or sign in with")
            Spacer(modifier = Modifier.height(16.dp))
            // Fila con botones de redes sociales
            SocialButtonsRow()
            Spacer(modifier = Modifier.height(32.dp))
            // Botón de Sign Up
            SignUpButton(onClick = { /* Acción para ir a Sign Up */ })
        }
    }
}

//Imagen de fondo
@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.background_sign_in)
    Image (
        painter = image,
        contentDescription = null,
        modifier = modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
fun BackgroundImagePreview() {
    TravelinTheme {
        BackgroundImage()
    }
}

// Composable para el contenedor con fondo de pantalla
@Composable
fun BackgroundContainer(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    // Caja que aplica el color de fondo y ocupa todoo el tamaño
    Box(
        modifier = modifier
            .background(backgroundColor)
    ) {
        // Imagen de fondo
        BackgroundImage(modifier = Modifier.fillMaxSize())
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun BackgroundContainerPreview() {
    TravelinTheme {
        BackgroundContainer(backgroundColor = Color(0xFF009688)) {
            Text(text = "Background Preview", color = Color.White)
        }
    }
}

// Composable para el título principal
@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            color = Color.White
        ),
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    TravelinTheme {
        TitleText(text = "Let's Travel you in.")
    }
}

// Composable para el subtítulo
@Composable
fun SubtitleText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        modifier = Modifier.padding(bottom = 24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SubtitleTextPreview() {
    TravelinTheme {
        SubtitleText(text = "Discover the World with Every Sign In")
    }
}

// Composable para el campo de texto de Email/Phone
@Composable
fun EmailField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
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
}

@Preview(showBackground = true)
@Composable
fun EmailFieldPreview() {
    TravelinTheme {
        EmailField(value = "example@mail.com", onValueChange = {})
    }
}

// Composable para el campo de texto de Password con toggle de visibilidad
@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            // Selecciona el ícono según el estado de visibilidad de la contraseña
            val icon = if (passwordVisible) {
                painterResource(id = android.R.drawable.ic_menu_view)
            } else {
                painterResource(id = android.R.drawable.ic_lock_idle_lock)
            }
            IconButton(onClick = onTogglePasswordVisibility) {
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
}

@Preview(showBackground = true)
@Composable
fun PasswordFieldPreview() {
    TravelinTheme {
        PasswordField(
            password = "password",
            onPasswordChange = {},
            passwordVisible = false,
            onTogglePasswordVisibility = {}
        )
    }
}

// Composable para el botón de "Forgot password?"
@Composable
fun ForgotPasswordButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.padding(end = 16.dp, top = 8.dp)
    ) {
        Text(
            text = "Forgot password?",
            style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordButtonPreview() {
    TravelinTheme {
        ForgotPasswordButton(onClick = {})
    }
}

// Composable para el botón de "Sign In"
@Composable
fun SignInButton(text: String, buttonColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInButtonPreview() {
    TravelinTheme {
        SignInButton(text = "Sign In", buttonColor = Color(0xFF00796B), onClick = {})
    }
}

// Composable para el texto que separa el inicio de sesión con redes sociales
@Composable
fun SocialLoginText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun SocialLoginTextPreview() {
    TravelinTheme {
        SocialLoginText(text = "or sign in with")
    }
}

// Composable para la fila de botones de redes sociales
@Composable
fun SocialButtonsRow() {
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
}

@Preview(showBackground = true)
@Composable
fun SocialButtonsRowPreview() {
    TravelinTheme {
        SocialButtonsRow()
    }
}

// Composable para el botón de "Sign Up"
@Composable
fun SignUpButton(onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpButtonPreview() {
    TravelinTheme {
        SignUpButton(onClick = {})
    }
}

// Composable para el botón de redes sociales (común para Google, Apple y Facebook)
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
fun SocialButtonPreview() {
    TravelinTheme {
        SocialButton(
            text = "Google",
            backgroundColor = Color.White,
            textColor = Color.Gray
        )
    }
}

/*
==============================================================================================
==============================================================================================
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
                onClick = { *//* Aquí irá la acción de 'olvidó contraseña' *//* },
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
                onClick = { *//* Acción de Sign In *//* },
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
                onClick = { *//* Acción para ir a Sign Up *//* }
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
*/
