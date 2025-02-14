package com.example.rotainteligente
// Ajuste este pacote para corresponder à estrutura do seu projeto

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
import com.example.rotainteligente.view.CadastroTela
import com.example.rotainteligente.view.ConfirmationScreen
import com.example.rotainteligente.view.motorista.CounterScreen
import com.example.rotainteligente.view.Home
import com.example.rotainteligente.view.LoginScreen
import com.example.rotainteligente.view.monitor.EntradaTela
import com.example.rotainteligente.view.monitor.MotoristaLista
import com.example.rotainteligente.view.monitor.RelatorioLista
import com.example.rotainteligente.view.monitor.RouteStatusScreen
import com.example.rotainteligente.view.monitor.SaidaTela
import com.example.rotainteligente.view.monitor.TrafficControl
import com.example.rotainteligente.view.motorista.OnibusTela

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
                    NavHost(navController = navController, startDestination = "controleTrafico") {
                        composable("home") { Home(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("cadastro") { CadastroTela(navController) }
                        composable("onibus") { OnibusTela(navController) }
                        composable("counter") { CounterScreen(navController) }
                        composable("confirmation") { ConfirmationScreen(navController) }

                        composable("controleTrafico") { TrafficControl(navController) }
                        composable("entrada") { EntradaTela(navController) }
                        composable("saida") { SaidaTela(navController) }
                        composable("statusdarota") { RouteStatusScreen(navController) }
                        composable("relatorioLista") { RelatorioLista(navController) }
                        composable("motoristaLista") { MotoristaLista(navController) }

                    }
                }
            }
        }
    }
}
