package com.example.app_ayuda_empleados_multinacional.Screens.Horas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_ayuda_empleados_multinacional.R
import com.example.app_ayuda_empleados_multinacional.data.Pais
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Horas(navigateToTemperaturas: () -> Unit, navigateToTelefonos: () -> Unit) {
    //Inicializo las variables que voy a usar
    val paisList = mutableListOf<Pais>()
    var hora = remember { mutableStateOf(0) }
    var minutos = remember { mutableStateOf(0) }
    AñadoPaises(paisList, hora.value,minutos.value)
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
                                "Teléfonos", style = MaterialTheme.typography.labelSmall
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
            Text(text = "Horas en distintas ciudades")
            Spacer(modifier = Modifier.padding(top = 10.dp))
        }
    }

}

@Composable
fun AñadoPaises(paisList: MutableList<Pais>, hora: Int, minutos: Int) {
    paisList.add(Pais("Madrid - España", R.drawable.madrid,hora = {hora}))
    paisList.add(Pais("Paris - Francia", R.drawable.paris,hora = {hora}))
    paisList.add(Pais("Londres - Reino Unido", R.drawable.londres,hora = {hora-1}))
    paisList.add(Pais("Porto Alegre - Brasil", R.drawable.puerto_alegre,hora = {hora-4}))
    paisList.add(Pais("Acapulco - México", R.drawable.acapulco,hora = {hora-7}))
    paisList.add(Pais("Vancouver - Canadá", R.drawable.vancouver,hora = {hora-9}))
    paisList.add(Pais("Houston - Estados Unidos de América", R.drawable.houston,hora = {hora-7}))
    paisList.add(Pais("Casablanca - Marruecos", R.drawable.casablanca,hora = {hora}))
    paisList.add(Pais("Osaka - Japón", R.drawable.osaka,hora = {hora+8}))
    paisList.add(Pais("Melbourne - Australia", R.drawable.melbourne,hora={hora+10}))
    paisList.add(Pais("Ankara - Turquia", R.drawable.ankara,hora={hora+2}))
    paisList.add(Pais("Dubai - Emiratos Árabes Unidos", R.drawable.dubai,hora={hora+3}))
}
