package com.example.rotainteligente.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)   // Tela de Login
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                val (nome, senha, butaoLogin, butaoCadastrar, esqueci) = createRefs()

                // Campo de usuário
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier
                        .constrainAs(nome) {
                            top.linkTo(parent.top, margin = 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                )

                // Campo de senha
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .constrainAs(senha) {
                            top.linkTo(nome.bottom, margin = 24.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                )

                // Botão de login
                Button(
                    onClick = {
                        val userType = checkUserType(username, password)
                        when (userType) {
                            "monitor" -> navController.navigate("statusdarota")
                            "motorista" -> navController.navigate("onibus")
                            else -> navController.navigate("onibus") // Pode ser uma tela de erro ou outra tela
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                        .constrainAs(butaoLogin) {
                            top.linkTo(senha.bottom, margin = 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) { Text("Login") }

                // Botão de cadastro
                Button(
                    onClick = { navController.navigate("cadastro") },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                        .constrainAs(butaoCadastrar) {
                            top.linkTo(butaoLogin.bottom, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }

                ) { Text("Cadastrar") }
            }
        }
    }
}

// Simula a verificação do tipo de usuário
fun checkUserType(username: String, password: String): String {
    return when (username) {
        "monitorUser" -> "monitor"
        "motoristaUser" -> "motorista"
        else -> "desconhecido"
    }
}


//@Preview(showBackground = true)
//@Composable
//fun MostrePreview(){
//    RotaInteligenteTheme{
//        LoginScreen()
//    }
//}
