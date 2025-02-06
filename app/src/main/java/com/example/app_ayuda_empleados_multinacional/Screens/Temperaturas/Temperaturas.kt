package com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
@Composable
fun Temperaturas(navigateToHoras: () -> Unit, navigateToTelefonos: () -> Unit) {
    Column( modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Temperaturas")
        Row( modifier =  Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {  }) {
                Text(text = "Ir a horas")
            }
            Button(onClick = {  }) {
                Text(text = "Ir a telefonos")
            }
        }
    }
}