package com.example.app_ayuda_empleados_multinacional.Navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_ayuda_empleados_multinacional.Screens.Horas.Horas
import com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas.Temperaturas
import com.example.app_ayuda_empleados_multinacional.Screens.Telefonos.Telefonos
@Composable
fun NavegationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Telefonos) {
        composable<Horas> {
            Horas(
                navigateToTemperaturas = { navController.navigate(Temperaturas) },
                navigateToTelefonos = { navController.navigate(Telefonos) }
            )
        }
        composable<Temperaturas>{
            Temperaturas(
                navigateToHoras = { navController.navigate(Horas) },
                navigateToTelefonos = { navController.navigate(Telefonos) }
            )
        }
        composable<Telefonos>{
            Telefonos(
                navigateToHoras = { navController.navigate(Horas) },
                navigateToTemperaturas = { navController.navigate(Temperaturas) }
            )
        }
    }
}
@Preview
@Composable
fun NavegacionPreview(){
    NavegationWrapper()
}