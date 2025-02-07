package com.example.app_ayuda_empleados_multinacional.Screens.Telefonos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Telefono(navigateToHoras: () -> Unit, navigateToTemperaturas: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Temperaturas")
        Row( modifier =  Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navigateToHoras() }) {
                Text(text = "Ir a horas")
            }
            Button(onClick = {navigateToTemperaturas() }) {
                Text(text = "Ir a temperatura")
            }
        }
    }
}