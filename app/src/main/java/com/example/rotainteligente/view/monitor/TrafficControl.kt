package com.example.rotainteligente.view.monitor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TrafficControl(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("entrada") }) {
            Text("Entrada")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("saida") }) {
            Text("Saida")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("statusdarota") }) {
            Text("Status da Rota")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("relatorioLista") }) {
            Text("Lista de Relatórios")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("motoristaLista") }) {
            Text("Lista de Motoristas")
        }
    }
}
