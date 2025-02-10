package com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.app_ayuda_empleados_multinacional.R
import com.example.compose.onErrorContainerLight
import com.example.compose.onPrimaryContainerDark
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryLight
import com.example.compose.surfaceLight
import com.example.compose.tertiaryContainerLightHighContrast
import com.example.ui.theme.bodyFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Temperaturas(navigateToHoras: () -> Unit, navigateToTelefonos: () -> Unit) {
    var temperature by remember { mutableStateOf(-30f) }
    var isFahrenheit by remember { mutableStateOf(false) }
    var guardarTemp by remember { mutableStateOf(listOf<Float>()) }
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
                    IconButton(onClick = { },colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White)) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Editar",
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                    IconButton(onClick = { },colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White)) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "Login",
                            modifier = Modifier.padding(0.dp),
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = onErrorContainerLight,
                    titleContentColor = onPrimaryContainerDark


                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                containerColor = onErrorContainerLight
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /*Pantalla actual*/ },modifier = Modifier.weight(1f),colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = Icons.Default.Thermostat, contentDescription = "Conversor temperaturas")
                            Text("Temperaturas", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = {navigateToHoras() },modifier = Modifier.weight(1f),colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    )
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Schedule, contentDescription = "Horas en distintas ciudades")
                            Text("Horas", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = { navigateToTelefonos() },modifier = Modifier.weight(1f),colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Phone, contentDescription = "Teléfonos de ayuda y contactos")
                            Text("Teléfonos", style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ) { paddinValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddinValues).background(color = surfaceLight), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            Spacer(modifier= Modifier.padding(bottom = 15.dp))
            Text("Conversores de temperatura", fontFamily = bodyFontFamily, fontSize = 30.sp, textAlign = TextAlign.Center,modifier = Modifier.padding(horizontal = 7.dp))
            Spacer(modifier= Modifier.padding(bottom = 15.dp))
            Text("Temperatura actual: ${if (isFahrenheit) celsiusToFahrenheit(temperature.toInt()) else temperature.toInt()} ${if (isFahrenheit) "°F" else "°C"}",
                fontSize = 20.sp, modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier= Modifier.padding(bottom = 15.dp))
            Slider(
                        value = temperature,
                        onValueChange = { temperature = it },
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Black,
                            activeTrackColor = Color.Gray,
                            inactiveTrackColor = Color.Gray,
                        ),
                        valueRange = -30f..55f,
                        steps = 85,
                modifier = Modifier.padding(horizontal = 16.dp)

            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Pasar a Fahrenheit", fontSize = 20.sp)
                Checkbox(
                    checked = isFahrenheit,
                    onCheckedChange = { isFahrenheit = it },
                    modifier = Modifier .align(Alignment.CenterVertically)
                )
            }
            Box( contentAlignment = Alignment.Center){
                Image( imageVector = Icons.Default.Thermostat, contentDescription = "Icono temperatura", modifier = Modifier.size(90.dp))
                Row (){
                    Text("${temperature.toInt()} °C", modifier = Modifier.padding(end = 25.dp))
                    Text("${celsiusToFahrenheit(temperature.toInt())}°F", modifier = Modifier.padding(start = 10.dp))
                }
            }
            Button(onClick = { guardarTemp = guardarTemp + temperature }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
            ) {
                Text("Guardar temperatura", fontSize = 18.sp)
            }

            Spacer(modifier= Modifier.padding(bottom = 15.dp))
            LazyColumn {
                items(guardarTemp){ (temperature.toInt())
                    Row {
                        val iconTemp = when (temperature){
                            in -30f..12f ->Icons.Default.AcUnit
                            in 13f..25f -> Icons.Default.Cloud
                            in 26f..55f -> Icons.Default.LocalFireDepartment
                            else -> Icons.Default.Thermostat }
                        Image(imageVector = iconTemp, contentDescription = "Icono temperatura")
                        Text(text = "Temperatura guardada: ${temperature.toInt()}°C - ${celsiusToFahrenheit(temperature.toInt())}°F", fontSize = 14.sp)

                    }
                }
            }
        }
    }
}
@Composable
fun añadirTemperatura(temperature: Float, guardarTemp: List<Float>) {
    if (guardarTemp.size >= 50){
        guardarTemp.drop(0)
    }  else{
        guardarTemp.add(temperature)
    }
}


fun celsiusToFahrenheit(celsius: Int): Int {
    return ((celsius * 9 / 5) + 32)
}