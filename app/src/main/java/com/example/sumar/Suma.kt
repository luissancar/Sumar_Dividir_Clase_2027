package com.example.sumar

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment

@Preview
@Composable
fun Suma(modifier: Modifier = Modifier) {
    var n1 by rememberSaveable { mutableStateOf("") }
    var n2 by rememberSaveable { mutableStateOf("") }
    var res by rememberSaveable { mutableStateOf("") }
    val botonHabilitado = n1.toIntOrNull() != null && n2.toIntOrNull() != null

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(32.dp))
        OutlinedTextField(
            value = n1,
            onValueChange = {
                if (it.all { caracter -> caracter.isDigit() })
                    n1 = it
            },
            label = { Text("Primer número") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = n2,
            onValueChange = {
                if (it.all { caracter -> caracter.isDigit() })
                    n2 = it
            },
            label = { Text("Segundo número") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                res = (n1.toInt() + n2.toInt()).toString()
            },
            enabled = botonHabilitado,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "SUMAR",
                fontSize = 18.sp
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                res = (n1.toInt() / n2.toInt()).toString()
            },
            enabled = n1.toIntOrNull() != null &&
                    n2.toIntOrNull() != null &&
                    n2.toInt() != 0,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "DIVIDIR",
                fontSize = 18.sp
            )
        }

        Spacer(Modifier.height(32.dp))
        if (res.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Resultado",
                    fontSize = 16.sp
                )
                Text(
                    text = res,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}