package com.example.app_ayuda_empleados_multinacional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.app_ayuda_empleados_multinacional.Navegation.NavegationWrapper
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         AppTheme {
             NavegationWrapper()
         }
            }
        }
    }
