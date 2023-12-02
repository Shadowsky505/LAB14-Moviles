package com.aldair.laboratorio14

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(viewModel: EjemploViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fecha by remember { mutableStateOf("") }

        TextField(
            value = fecha,
            onValueChange = {fecha = it},
            label = { Text("Ingrese la fecha (Ej: 20210307)") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.obtenerDatosParaFecha(fecha.toInt())
            }
        ) {
            Text(text = "Obtener datos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = viewModel.mensaje)
    }
}
