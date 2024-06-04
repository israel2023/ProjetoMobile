package br.com.israelferreira.projetomobile.appfilmes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.israelferreira.projetomobile.appfilmes.R
import br.com.israelferreira.projetomobile.appfilmes.model.Login
//import java.lang.reflect.Modifier

@Composable
fun TelaLogin(onLogin: (Login) -> Unit) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    /*Icon(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        tint = Color.Yellow,
        modifier = Modifier.size(32.dp)
    )*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Icon(
            painter = painterResource(id = R.drawable.logo), // Carrega o recurso do logo
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier.size(300.dp) // Ajuste o tamanho conforme necessário
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("senha") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val loginData = Login(email, senha)
                onLogin(loginData)

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )


        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaLogin() {
    MaterialTheme {
        TelaLogin(onLogin = {})
    }
}

