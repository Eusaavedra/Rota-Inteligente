package com.example.rotainteligente.view.monitor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.rotainteligente.model.Entrada
import com.example.rotainteligente.repository.Repository

@Composable
fun DadosEntrada(entrada: Entrada, navController: NavController){
    val RotaN = entrada.numeroRota
    val capacidade = entrada.capacidade
    val data = entrada.data
    val hora = entrada.hora

    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        ConstraintLayout(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            val (rota, rout, capac, date, HORA) = createRefs()

            Text(
                text = "Rota: 01",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(rota) {
                    top.linkTo(parent.top, 20.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
            )

            Text(
                text = "Rota: 01",
                modifier = Modifier.constrainAs(rout) {
                    top.linkTo(rota.bottom, 20.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Text(
                text = "17",
                modifier = Modifier.constrainAs(capac) {
                    top.linkTo(rota.bottom, 20.dp)
                    end.linkTo(parent.end, 10.dp)
                }
            )

            Text(
                text = "data",
                modifier = Modifier.constrainAs(date) {
                    top.linkTo(capac.bottom, 20.dp)
                    top.linkTo(rout.bottom, 20.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
            )
            Text(
                text = "hora",
                modifier = Modifier.constrainAs(HORA) {
                    top.linkTo(date.bottom, 20.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
            )
        }
    }
}
