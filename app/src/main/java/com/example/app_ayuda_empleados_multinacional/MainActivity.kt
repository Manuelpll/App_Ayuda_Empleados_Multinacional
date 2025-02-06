package com.example.app_ayuda_empleados_multinacional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_ayuda_empleados_multinacional.Navegation.NavegationWrapper
import com.example.app_ayuda_empleados_multinacional.ui.theme.App_Ayuda_Empleados_MultinacionalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_Ayuda_Empleados_MultinacionalTheme {
               NavegationWrapper()
                }
            }
        }
    }
