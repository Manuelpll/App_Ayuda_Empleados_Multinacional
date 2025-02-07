package com.example.app_ayuda_empleados_multinacional.Screens.Horas

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
fun Horas(navigateToTemperaturas: () -> Unit, navigateToTelefonos: () -> Unit) {
    Column( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Temperaturas")
        Row( modifier =  Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {navigateToTemperaturas()}) {
                Text(text = "Ir a temperaturas")
            }
            Button(onClick = { navigateToTelefonos() }) {
                Text(text = "Ir a telefonos")
            }
        }
    }
}