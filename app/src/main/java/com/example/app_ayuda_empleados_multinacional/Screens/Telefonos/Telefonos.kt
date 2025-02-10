package com.example.app_ayuda_empleados_multinacional.Screens.Telefonos

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.app_ayuda_empleados_multinacional.R
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Telefonos(navigateToHoras: () -> Unit, navigateToTemperaturas: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                }, navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.splatnot),
                            contentDescription = "Logo_Empresa",
                            modifier = Modifier.size(90.dp),
                        )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Editar",
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "Login",
                            modifier = Modifier.padding(0.dp),
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryLight,
                    titleContentColor = onPrimaryContainerLight


                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                containerColor = primaryLight
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navigateToTemperaturas() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = Icons.Default.Thermostat, contentDescription = "Conversor temperaturas")
                            Text("Conversor temperaturas", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = {navigateToHoras() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Schedule, contentDescription = "Horas en distintas ciudades")
                            Text("Horas en distintas ciudades", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = { /*Pantalla actual*/ },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Phone, contentDescription = "Teléfonos de ayuda y contactos")
                            Text("Teléfonos de ayuda", style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Temperaturas")
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { navigateToHoras() }) {
                    Text(text = "Ir a horas")
                }
                Button(onClick = { navigateToTemperaturas() }) {
                    Text(text = "Ir a temperatura")
                }
            }
        }
    }
}