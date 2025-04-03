package dev.softserve.travelin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.softserve.travelin.data.model.User
import dev.softserve.travelin.ui.component.UserInfo
import dev.softserve.travelin.ui.theme.TravelinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun UserInfoScreen(){
    val user = User("Paul",2000,"D:\\Klotin\\SoftServer\\softserve-flights-app\\app\\src\\main\\res\\drawable\\img.png")

    UserInfo(user=user)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelinTheme {
        Greeting("Android")
    }
}
