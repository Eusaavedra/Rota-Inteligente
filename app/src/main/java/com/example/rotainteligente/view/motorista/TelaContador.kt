package com.example.rotainteligente.view.motorista

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterScreen(navController: NavController) {
    var count by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Contador de Passageiros",
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {
                val (tipoVeiculo, sos, contador, subtrair, quant, fim) = createRefs()

                Text(
                    "Veículo - ", // Quantidade variavel
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.constrainAs(tipoVeiculo) {
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    }
                )

                IconButton(
                    onClick = { /* Lógica do botão de emergência */ },
                    modifier = Modifier
                        .size(48.dp)
                        .constrainAs(sos) {
                            top.linkTo(parent.top, margin = 20.dp)
                            end.linkTo(parent.end, margin = 10.dp)
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Emergência",
                        tint = Color.Red,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Button(
                    onClick = { count++ },  // Resetar contador depois de pressionar FINALIZAR
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4)), // Verde mais vibrante
                    modifier = Modifier
                        .size(width = 300.dp, height = 300.dp)
                        .constrainAs(contador) {
                            top.linkTo(tipoVeiculo.bottom, margin = 50.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Text(
                        "Adicionar",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                }

                Button(
                    onClick = { if (count > 0) count-- },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)), // Vermelho mais vibrante
                    modifier = Modifier.padding(horizontal = 16.dp).height(50.dp)
                        .constrainAs(subtrair) {
                            top.linkTo(contador.bottom, margin = 40.dp)
                            start.linkTo(parent.start)
                        }
                ) {
                    Text(
                        "Subtrair",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                }

                OutlinedCard(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier.size(width = 90.dp, height = 50.dp)
                        .constrainAs(quant) {
                            top.linkTo(contador.bottom, margin = 40.dp)
                            end.linkTo(parent.end)
                        }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$count",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }

                Button(
                    onClick = { navController.navigate("confirmation") },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)), // Azul mais vibrante
                    modifier = Modifier.padding(top = 20.dp).height(50.dp)
                        .fillMaxWidth(0.8f).constrainAs(fim) {
                            top.linkTo(quant.bottom, margin = 20.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Text(
                        "Finalizar Contagem",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                }
            }
        }
    }
}

