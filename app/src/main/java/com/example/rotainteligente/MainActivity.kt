package com.example.rotainteligente
// Ajuste este pacote para corresponder à estrutura do seu projeto

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rotainteligente.ui.theme.RotaInteligenteTheme
import java.util.prefs.Preferences


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotaInteligenteTheme {
                // Use o tema aqui
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                        composable("busType") { BusTypeScreen(navController) }
                        composable("counter") { CounterScreen(navController) }
                        composable("confirmation") { ConfirmationScreen(navController) }
                    }
                }
            }
        }
    }
}

