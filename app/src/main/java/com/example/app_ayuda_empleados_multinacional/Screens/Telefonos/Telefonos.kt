package com.example.app_ayuda_empleados_multinacional.Screens.Telefonos

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.compose.onPrimaryContainerDark
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryDark
import com.example.compose.primaryLight
import com.example.compose.tertiaryDark
import com.example.ui.theme.bodyBoldSpex
import com.example.ui.theme.bodyMonse
import com.example.ui.theme.bodyMonseBold

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Telefonos(navigateToHoras: () -> Unit, navigateToTemperaturas: () -> Unit,viewModel: TelefonosViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                }, navigationIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.splatnot),
                            contentDescription = "Logo_Empresa",
                            modifier = Modifier.size(130.dp) .padding(start= 20.dp),
                        )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Editar",
                            modifier = Modifier.padding(0.dp).size(15.dp)
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "Login",
                            modifier = Modifier.padding(0.dp).size(15.dp)
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
                    IconButton(onClick = { navigateToTemperaturas() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = Icons.Default.Thermostat, contentDescription = "Conversor temperaturas", modifier = Modifier.size(25.dp))
                            Text("Temperaturas", style = MaterialTheme.typography.labelMedium,
                                maxLines = 2)
                        }
                    }
                    IconButton(onClick = {  },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Phone, contentDescription = "Teléfonos de ayuda", modifier = Modifier.size(25.dp))
                            Text("Telefonos", style = MaterialTheme.typography.labelMedium)
                        }
                    }
                    IconButton(onClick = {navigateToHoras() },modifier = Modifier.weight(1f)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Schedule, contentDescription = "Horas en distintas ciudades", modifier = Modifier.size(25.dp))
                            Text("Horas", style = MaterialTheme.typography.labelMedium,
                                maxLines = 2)
                        }
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Teléfonos de ayuda y contactos",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp),
                fontFamily = bodyBoldSpex
            )

            Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        SelectorDropdown(
                            seleccion = viewModel.ciudadSeleccionada,
                            opciones = viewModel.ciudades
                        ) { viewModel.ciudadSeleccionada = it }
                    }

                    Box(modifier = Modifier.weight(1f)) {
                        SelectorDropdown(
                            seleccion = viewModel.servicioSeleccionado,
                            opciones = viewModel.servicios
                        ) { viewModel.servicioSeleccionado = it }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = obtenerMapa(viewModel.ciudadSeleccionada)),
                    contentDescription = "Mapa de ${viewModel.ciudadSeleccionada}",
                    modifier = Modifier
                        .size(300.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                viewModel.contactoActual?.let { contacto ->
                    Text(
                        "${contacto.ciudad}, ${contacto.pais}",
                        style = MaterialTheme.typography.displaySmall,
                        fontFamily = bodyMonse,
                        fontSize =  18.sp
                    )

                    SelectionContainer {
                        Text(
                            "${contacto.telefono}",
                            style = MaterialTheme.typography.headlineMedium,
                            fontFamily = bodyMonse
                        )
                    }

                    contacto.persona?.let { persona ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Contacto: ${persona.nombre}",
                            fontFamily = bodyMonse,
                            fontSize =  18.sp)
                        SelectionContainer { Text("Tel: ${persona.telefono}",
                            fontFamily = bodyMonse,
                            fontSize =  20.sp) }
                        SelectionContainer { Text("Email: ${persona.email}",
                            fontFamily = bodyMonseBold) }
                    }
                }
            }

        }
    }
}
//Funcion para DropdownMenu
@Composable
fun SelectorDropdown(seleccion: String, opciones: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        Button(onClick = { expanded = true }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red
        )) {
            Text(seleccion)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(opcion) },
                    onClick = {
                        onSelect(opcion)
                        expanded = false
                    }
                )
            }
        }
    }
}

// Obtener la imagen del mapa según la ciudad
fun obtenerMapa(ciudad: String): Int {
    return when (ciudad) {
        "Madrid" -> R.drawable.madrid
        "París" -> R.drawable.paris
        "Londres" -> R.drawable.londres
        "Porto Alegre" -> R.drawable.puerto_alegre
        "Acapulco" -> R.drawable.acapulco
        "Vancouver" -> R.drawable.vancouver
        "Houston" -> R.drawable.houston
        "Casablanca" -> R.drawable.casablanca
        "Osaka" -> R.drawable.osaka
        "Melbourne" -> R.drawable.melbourne
        "Ankara" -> R.drawable.ankara
        "Dubai" -> R.drawable.dubai
        else ->R.drawable.splatnot
    }
}