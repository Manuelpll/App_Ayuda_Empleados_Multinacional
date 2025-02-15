package com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_ayuda_empleados_multinacional.R
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Temperaturas(
    navigateToHoras: () -> Unit,
    navigateToTelefonos: () -> Unit,
    viewModel: TemperaturasViewModel = viewModel()
) {
    val temperature by viewModel.temperature.collectAsState()
    val isFahrenheit by viewModel.isFahrenheit.collectAsState()
    val guardarTemp by viewModel.guardarTemp.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                }, navigationIcon = {
                    Image(
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
                    IconButton(onClick = {navigateToHoras() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Schedule, contentDescription = "Horas en distintas ciudades")
                            Text("Horas en distintas ciudades", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = { navigateToTelefonos() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Phone, contentDescription = "Teléfonos de ayuda y contactos")
                            Text("Teléfonos de ayuda", style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text("Conversor de temperatura" , fontSize = 30.sp, modifier = Modifier.padding(bottom = 15.dp),fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(bottom = 15.dp))

            Text(
                text = "Temperatura actual: ${if (isFahrenheit) viewModel.celsiusToFahrenheit(temperature.toInt()) else temperature.toInt()} ${if (isFahrenheit) "°F" else "°C"}",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.padding(bottom = 15.dp))

            Slider(
                value = temperature,
                onValueChange = { viewModel.updateTemperature(it) },
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Gray,
                    inactiveTrackColor = Color.Gray
                ),
                valueRange = -30f..55f,
                steps = 85,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Pasar a Fahrenheit", fontSize = 20.sp)
                Checkbox(
                    checked = isFahrenheit,
                    onCheckedChange = { viewModel.toggleFahrenheit() }
                )
            }

            Box(contentAlignment = Alignment.Center) {
                Image(
                    imageVector = Icons.Default.Thermostat,
                    contentDescription = "Icono temperatura",
                    modifier = Modifier.size(90.dp)
                )
                Row {
                    Text("${temperature.toInt()} °C", modifier = Modifier.padding(end = 25.dp))
                    Text("${viewModel.celsiusToFahrenheit(temperature.toInt())}°F", modifier = Modifier.padding(start = 10.dp))
                }
            }

            Button(
                onClick = { viewModel.saveTemperature() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
            ) {
                Text("Guardar temperatura", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.padding(bottom = 15.dp))

            LazyColumn {
                items(guardarTemp) { temp ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        val iconTemp = when (temp) {
                            in -30f..12f -> Icons.Default.AcUnit
                            in 13f..25f -> Icons.Default.Cloud
                            in 26f..55f -> Icons.Default.LocalFireDepartment
                            else -> Icons.Default.Thermostat
                        }
                        Image(imageVector = iconTemp, contentDescription = "Icono temperatura")
                        Text(
                            text = "Temperatura guardada: ${temp.toInt()}°C - ${viewModel.celsiusToFahrenheit(temp.toInt())}°F",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
