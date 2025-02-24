package com.example.app_ayuda_empleados_multinacional.Screens.Encuesta

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas.TemperaturasViewModel
import com.example.compose.onPrimaryContainerDark
import com.example.ui.theme.bodyBoldSpex
import com.example.ui.theme.bodyMonse
import com.example.ui.theme.bodyMonseBold
import com.example.ui.theme.bodySpex

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Encuesta(
    navigateToHoras: () -> Unit,
    viewModel: EncuestaViewModel = viewModel(),
    navigateToTemperaturas: () -> Unit,
    navigateToTelefonos: () -> Unit
) {
    val expadRes by viewModel.expandedRE.collectAsState()
    val expadCo by viewModel.expadedCo.collectAsState()
    val expadHij by viewModel.expadedHij.collectAsState()
    val checkC by viewModel.Cocheck.collectAsState()
    val checkR by viewModel.Rescheck.collectAsState()
    val coche by viewModel.Coche.collectAsState()
    val residencia by viewModel.Residencia.collectAsState()
    val hijos by viewModel.Hijos.collectAsState()
    val send by viewModel.send.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {}, navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.splatnot),
                        contentDescription = "Logo_Empresa",
                        modifier = Modifier.size(130.dp).padding(start = 20.dp),
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Editar",
                            modifier = Modifier.padding(0.dp).size(35.dp)
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
                containerColor = onPrimaryContainerDark
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}, modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painterResource(R.drawable.icono_datos),
                                contentDescription = "Encuesta de empleado ",
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                "Encuesta", style = MaterialTheme.typography.labelMedium
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
                                contentDescription = "Teléfonos de ayuda ",
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                "Teléfonos", style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                    IconButton(
                        onClick = { navigateToTemperaturas() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Default.Thermostat,
                                contentDescription = "Horas en distintas ciudades",
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                "Temperaturas", style = MaterialTheme.typography.labelMedium,
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
                                Icons.Default.Schedule,
                                contentDescription = "Teléfonos de ayuda",
                                modifier = Modifier.size(25.dp)
                            )
                            Text("Horas", style = MaterialTheme.typography.labelMedium)
                        }
                    }

                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text("Encuesta de RRHH", fontSize = 18.sp, fontFamily = bodyBoldSpex)
            Spacer(modifier = Modifier.height(10.dp))
            Card(onClick = {}, modifier = Modifier.size(350.dp, 100.dp)) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "¿Donde dispone de residencia" +
                                "en la ciudad donde esta destinado?",
                        fontFamily = bodySpex, fontSize = 15.sp, modifier = Modifier.size(150.dp)
                    )
                    Checkbox(
                        checked = checkR,
                        onCheckedChange = { viewModel.toggleCheckRes() }
                    )
                    Button(onClick = { viewModel.ExpandRes() }) {
                        if (checkR) {
                            Text(residencia)
                        }
                    }
                    DropdownMenu(
                        expanded = expadRes,
                        onDismissRequest = { viewModel.ExpandRes() }) {
                        DropdownMenuItem(
                            text =
                            { Text("Alquiler") },
                            onClick = { viewModel.updateResidencia("Alquiler") },
                        )
                        DropdownMenuItem(
                            text = { Text("En propiedad") },
                            onClick = { viewModel.updateResidencia("En propiedad") },
                        )
                        DropdownMenuItem(
                            text = { Text("De familiares") },
                            onClick = { viewModel.updateResidencia("De familiares") },
                        )
                        DropdownMenuItem(
                            text = { Text("De amigos") },
                            onClick = { viewModel.updateResidencia("De amigos") },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(onClick = {}, modifier = Modifier.size(350.dp, 100.dp)) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "¿Tiene coche propio?",
                        fontFamily = bodyMonse,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                    Checkbox(
                        checked = checkC,
                        onCheckedChange = { viewModel.toggleCheckCo() }
                    )

                    Button(onClick = { viewModel.ExpandCo() }) {
                        if (checkC) {
                            Text(coche)
                        }
                    }
                    DropdownMenu(
                        expanded = expadCo,
                        onDismissRequest = { viewModel.ExpandCo() }) {
                        DropdownMenuItem(
                            text = { Text("Compacto") },
                            onClick = { viewModel.updateCoche("Compacto") },
                        )
                        DropdownMenuItem(
                            text = { Text("Berlina") },
                            onClick = { viewModel.updateCoche("Berlina") },
                        )
                        DropdownMenuItem(
                            text = { Text("SUV") },
                            onClick = { viewModel.updateCoche("SUV") },
                        )
                        DropdownMenuItem(
                            text = { Text("Familiar") },
                            onClick = { viewModel.updateCoche("Familiar") },
                        )
                        DropdownMenuItem(
                            text = { Text("Deportivo") },
                            onClick = { viewModel.updateCoche("Deportivo") },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(onClick = {}, modifier = Modifier.size(350.dp, 100.dp)) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Numero de Hijos",
                        fontFamily = bodyMonse, fontSize = 15.sp,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Button(onClick = { viewModel.ExpandHij() }) { Text("$hijos") }
                    DropdownMenu(
                        expanded = expadHij,
                        onDismissRequest = { viewModel.ExpandHij() }) {
                        DropdownMenuItem(
                            text = { Text("0") },
                            onClick = { viewModel.updateHijos(0) })
                        DropdownMenuItem(
                            text = { Text("1") },
                            onClick = { viewModel.updateHijos(1) })
                        DropdownMenuItem(
                            text = { Text("2") },
                            onClick = { viewModel.updateHijos(2) })
                        DropdownMenuItem(
                            text = { Text("3") },
                            onClick = { viewModel.updateHijos(3) })
                        DropdownMenuItem(
                            text = { Text("4") },
                            onClick = { viewModel.updateHijos(4) })
                        DropdownMenuItem(
                            text = { Text("5") },
                            onClick = { viewModel.updateHijos(5) })
                    }
                }
            }
            Button(onClick = { viewModel.toggleSend() }) {
                if (!send) {
                    Text("Enviar")
                } else {
                    Text("Enviado")
                }
            }
            if (send) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        "Resultado",
                        fontSize = 20.sp,
                        fontFamily = bodyMonseBold,
                        modifier = Modifier.padding(start = 40.dp)
                    )
                    Row(
                        modifier = Modifier.size(60.dp, 90.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Casa", modifier = Modifier.padding(start = 10.dp), fontFamily = bodyMonse,
                            fontSize = 15.sp)
                       if (checkC) {
                            Box(modifier = Modifier.fillMaxWidth(). padding(start = 20.dp)) {
                                Image(painter = painterResource(id= R.drawable.house), contentDescription = "Casa")
                                Image(painter = painterResource(id= R.drawable.checked), contentDescription = "Tiene")
                            }
                      } else {
                           Box(modifier = Modifier.fillMaxWidth(). padding(start = 20.dp)) {
                                Image(painter = painterResource(id= R.drawable.house), contentDescription = "Casa")
                                Image(painter =  painterResource(id= R.drawable.unchecked), contentDescription = "No tiene")
                            }
                        }
                        Text(residencia)
                    }
                    Row(
                        modifier = Modifier.size(60.dp, 90.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Coche", modifier = Modifier.padding(start = 10.dp) , fontFamily = bodyMonse,
                            fontSize = 15.sp)
                        if (checkC) {
                            Box(modifier = Modifier.fillMaxSize(). padding(start = 20.dp)) {
                                Image(painter = painterResource(id= R.drawable.car) , modifier = Modifier.size(80.dp), contentDescription = "Coche")
                                Image(painter = painterResource(id= R.drawable.checked), contentDescription = "Tiene")}
                        } else {
                            Box(modifier = Modifier.fillMaxSize(). padding(start = 20.dp)) {
                                Image(painter = painterResource(id= R.drawable.car), contentDescription = "Coche")
                                Image(painter =  painterResource(id= R.drawable.unchecked), contentDescription = " No tiene")
                            }
                        }
                        Text(coche, modifier = Modifier.padding(horizontal = 10.dp) .size(60.dp,50.dp))
                    }
                    Row(
                        modifier = Modifier.size(60.dp, 90.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Niños", modifier = Modifier.padding(start = 10.dp), fontFamily = bodyMonse,
                            fontSize = 15.sp)
                        Row(modifier = Modifier.size(60.dp, 50.dp)) {
                            Image(painter = painterResource(id = R.drawable.baby), contentDescription = "Niños")
                        }
                        Slider(
                            value = hijos.toFloat(),
                            onValueChange = { viewModel.updateHijos(hijos) },
                            colors = SliderDefaults.colors(
                                thumbColor = Color.Black,
                                activeTrackColor = Color.Gray,
                                inactiveTrackColor = Color.Gray
                            ),
                            valueRange = 0f..5f,
                            steps = 5,
                            modifier = Modifier.padding(start = 90.dp) .size(300.dp)
                        )
                    }

                }
            }
        }
    }
}
