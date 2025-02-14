package com.example.rotainteligente.view.motorista

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnibusTela(navController: NavController) {
    var placa by remember { mutableStateOf("") }
    var RotaN by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedTurno by remember { mutableStateOf("Comercial") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Cadastrar Meu Ônibus",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = Color.White
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1976D2),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Campo de entrada para Placa do Veículo
            OutlinedTextField(
                value = placa,
                onValueChange = { placa = it },
                label = { Text("Placa do Ônibus") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = RotaN,
                onValueChange = { RotaN = it },
                label = { Text("Número da Rota") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Seletor de Turno
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedTurno,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                    label = { Text("Escolha o turno") },
                    trailingIcon = {
                        Icon(
                            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf("Comercial", "1 Turno", "2 Turno", "3 Turno").forEach { turno ->
                        DropdownMenuItem(
                            text = { Text(turno) },
                            onClick = {
                                selectedTurno = turno
                                expanded = false
                            }
                        )
                    }
                }
            }

            // Seleção da Quantidade de Assentos
            Text(
                text = "Quantidade de Assentos",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { navController.navigate("counter") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1976D2),
                        contentColor = Color.White
                    )
                ) { Text("16 lugares") }

                Button(
                    onClick = { navController.navigate("counter") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1976D2),
                        contentColor = Color.White
                    )
                ) { Text("32 lugares") }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun BusTypeScreenPreview() {
//    BusTypeScreen(navController = rememberNavController())
//}
