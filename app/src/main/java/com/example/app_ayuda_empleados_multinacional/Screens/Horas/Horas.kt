package com.example.app_ayuda_empleados_multinacional.Screens.Horas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.compose.onPrimaryContainerDark
import com.example.compose.tertiaryDark
import com.example.ui.theme.bodyBoldSpex
import com.example.ui.theme.bodyMonse
import com.example.ui.theme.bodyMonseBold

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Horas(
    navigateToTemperaturas: () -> Unit,
    navigateToTelefonos: () -> Unit,
    viewModel: HorasViewModel = viewModel()
) {
    //Inicializo las variables
    val paisList by viewModel.paises.collectAsState()
    val hora by viewModel.hora.collectAsState()
    val minutos by viewModel.minutos.collectAsState()
    val paisSeleccionado by viewModel.paisSeleccionado.collectAsState()
// Creo el Scafold
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                }, navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.splatnot),
                        contentDescription = "Logo_Empresa",
                        modifier = Modifier.size(130.dp).padding(start= 20.dp),
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Editar",
                            modifier = Modifier.padding(0.dp) .size(35.dp)
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "Login",
                            modifier = Modifier.padding(0.dp).size(35.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = onPrimaryContainerDark


                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                containerColor =  onPrimaryContainerDark
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {navigateToTemperaturas() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Thermostat, contentDescription = "Horas en distintas ciudades", modifier = Modifier.size(25.dp))
                            Text("Temperaturas", style = MaterialTheme.typography.labelMedium,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = {  },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Schedule, contentDescription = "Teléfonos de ayuda", modifier = Modifier.size(25.dp))
                            Text("Horas", style = MaterialTheme.typography.labelMedium)
                        }
                    }
                    IconButton(onClick = { navigateToTelefonos() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Phone, contentDescription = "Teléfonos de ayuda ", modifier = Modifier.size(25.dp))
                            Text("Teléfonos", style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Horas en distintas ciudades",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
                , fontFamily = bodyBoldSpex
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                items(paisList) { pais ->
                    Button(
                        onClick = { viewModel.seleccionarPais(pais) },
                        modifier = Modifier.padding(horizontal = 4.dp)
                    ) {
                        Text(pais.ciudad)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
//Añado los textField donde se van poniendo la hora y los minutos
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = hora.toString(),
                    onValueChange = { nuevoValor ->
                        nuevoValor.toIntOrNull()?.let { numero ->
                            if (numero in 0..23) {
                                viewModel.updateHora(numero)
                            }
                        }
                    },
                    label = { Text("Horas", fontFamily = bodyMonse) },
                    modifier = Modifier.width(100.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = minutos.toString(),
                    onValueChange =  { nuevoValor ->
                        nuevoValor.toIntOrNull()?.let { numero ->
                            if (numero in 0..59) {
                                viewModel.updateMinutos(numero)
                            }
                        }
                    },
                    label = { Text("Minutos", fontFamily = bodyMonse) },
                    modifier = Modifier.width(100.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Muestro la ciudad y la hora seleccionada
            paisSeleccionado?.let { pais ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = pais.image),
                        contentDescription = "Imagen de ${pais.ciudad}",
                        modifier = Modifier.size(250.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "${pais.ciudad}, ${pais.pais}",
                            fontSize = 20.sp,
                            fontFamily = bodyMonseBold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(
                            text = "${
                                viewModel.calcularHoraLocal(
                                    hora,
                                    pais.diferenciaHoras
                                )
                            }:$minutos",
                            fontSize = 28.sp,
                            fontFamily = bodyMonseBold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Lista de  las otras ciudades
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(paisList.filter { it != paisSeleccionado }) { pais ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = pais.image),
                            contentDescription = "Mapa de ${pais.ciudad}",
                            modifier = Modifier.size(210.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = pais.ciudad,
                            fontSize = 18.sp,
                            fontFamily = bodyMonseBold
                        )
                        Text(
                            text = "${viewModel.calcularHoraLocal(hora, pais.diferenciaHoras)}:$minutos",
                            fontSize = 17.sp,
                            fontFamily = bodyMonseBold
                        )
                    }
                }
            }
        }
    }
}

