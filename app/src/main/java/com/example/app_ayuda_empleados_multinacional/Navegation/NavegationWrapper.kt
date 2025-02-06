package com.example.app_ayuda_empleados_multinacional.Navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_ayuda_empleados_multinacional.Screens.Horas.Horas
import com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas.Temperaturas
import com.example.app_ayuda_empleados_multinacional.Screens.Telefonos.Telefono
@Composable
fun NavegationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "temperaturas") {
        composable<Horas> {
            Horas(
                navigateToTemperaturas = { navController.navigate("temperaturas") },
                navigateToTelefonos = { navController.navigate("telefonos") }
            )
        }
        composable<Temperaturas>{
            Temperaturas(
                navigateToHoras = { navController.navigate("horas") },
                navigateToTelefonos = { navController.navigate("telefonos") }
            )
        }
        composable<Telefono>{
            Telefono(
                navigateToHoras = { navController.navigate("horas") },
                navigateToTemperaturas = { navController.navigate("temperaturas") }
            )
        }
    }
}
