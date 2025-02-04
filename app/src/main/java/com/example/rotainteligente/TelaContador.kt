package com.example.rotainteligente

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CounterScreen(navController: NavController) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { /* Lógica do botão de emergência */ }) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Emergência",
                    tint = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Contagem: $count", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Adicionar")
            }
            Button(onClick = { if (count > 0) count-- }) {
                Text("Subtrair")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("confirmation") }) {
            Text("Finalizar Contagem")
        }
    }
}

