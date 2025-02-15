package com.example.app_ayuda_empleados_multinacional.Screens.Horas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.app_ayuda_empleados_multinacional.data.Pais
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Horas(navigateToTemperaturas: () -> Unit,
          navigateToTelefonos: () -> Unit,
          viewModel: HorasViewModel = viewModel()
) {
    //Inicializo las variables que voy a usar
    val paisList  by viewModel.paises.collectAsState()
    val hora  by  viewModel.hora.collectAsState()
    val minutos  by viewModel.minutos.collectAsState()
    val paisSeleccionado by viewModel.paisSeleccionado.collectAsState()
    //Creo un Scaffold para agregar el topBar y el bottomBar
    Scaffold(
        topBar = {
            TopAppBar(
                title = {}, navigationIcon = {
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
                    IconButton(
                        onClick = { navigateToTemperaturas() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Thermostat,
                                contentDescription = "Conversor temperaturas"
                            )
                            Text(
                                "Temperaturas", style = MaterialTheme.typography.labelSmall,
                                maxLines = 2
                            )
                        }
                    }
                    IconButton(
                        onClick = { navigateToTelefonos() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Default.Phone,
                                contentDescription = "Teléfonos de ayuda y contactos"
                            )
                            Text(
                                "Teléfonos de Ayuda", style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Horas en distintas ciudades",fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                items(paisList){ pais->
                    Button(onClick = {viewModel.seleccionarPais(pais)}, modifier = Modifier.width(130.dp).height(50.dp) .clip(MaterialTheme.shapes.extraSmall), colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    )){
                        Text(pais.ciudad)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = hora.toString(),
                    onValueChange = { nuevoValor ->
                        nuevoValor.toIntOrNull()?.let { viewModel.updateHora(it) }
                    },
                    label = { Text("Horas") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )

                TextField(
                    value = minutos.toString(),
                    onValueChange = { nuevoValor ->
                        nuevoValor.toIntOrNull()?.let { viewModel.updateMinutos(it) }
                    },
                    label = { Text("Minutos") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Button(onClick = {}) {
                    Text("Mostrar Hora")
                }
            }
            paisSeleccionado?.let { pais ->
                Row(modifier = Modifier.size(700.dp)) {
                    Box(modifier = Modifier.size(width = 70.dp, height = 30.dp)) {
                        Column(modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = pais.image),
                                contentDescription = "Imagen de ${pais.ciudad}",
                                modifier = Modifier.size(500.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = " ${pais.ciudad}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                    Text("${paisSeleccionado!!.hora.invoke()} : $minutos")
                }
            }
        }
    }

}
