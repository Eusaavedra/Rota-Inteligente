package com.example.rotainteligente.view.monitor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DriverStatusViewModel : ViewModel() {
    // Mapa com o nome do motorista e o status (false = não finalizado, true = finalizado)
    private val _driverStatus = MutableStateFlow<Map<String, Boolean>>(
        mapOf(
            "Motorista 1" to false,
            "Motorista 2" to false,
            "Motorista 3" to false
        )
    )
    val driverStatus: StateFlow<Map<String, Boolean>> = _driverStatus

    fun updateDriverStatus(driverName: String, finished: Boolean) {
        _driverStatus.value = _driverStatus.value.toMutableMap().apply {
            put(driverName, finished)
        }
    }
}

@Composable
fun RouteStatusScreen(
    navController: NavController,
    viewModel: DriverStatusViewModel = viewModel()
) {
    // Observa o estado compartilhado do ViewModel
    val driverStatus by viewModel.driverStatus.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Status da Rota",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Exibe cada motorista com um botão cujo status define a cor
        driverStatus.forEach { (driver, finished) ->
            Button(
                onClick = {
                    // Armazena o nome do motorista e navega para a tela de confirmação
                    navController.currentBackStackEntry?.savedStateHandle?.set("statusdarota", driver)
                    navController.navigate("confirmation")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (finished) Color.Green else Color(0xFFFFA500)
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(text = driver, color = Color.White)
            }
        }
    }
}
