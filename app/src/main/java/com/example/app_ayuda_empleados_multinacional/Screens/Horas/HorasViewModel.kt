package com.example.app_ayuda_empleados_multinacional.Screens.Horas

import androidx.lifecycle.ViewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.app_ayuda_empleados_multinacional.data.Pais
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HorasViewModel : ViewModel() {
    //Inicializo las variables que se van a guarda
    private val _hora = MutableStateFlow(0)
    val hora: StateFlow<Int> = _hora

    private val _minutos = MutableStateFlow(0)
    val minutos: StateFlow<Int> = _minutos

    private val _paises = MutableStateFlow<List<Pais>>(emptyList())
    val paises: StateFlow<List<Pais>> = _paises

    private val _paisSeleccionado = MutableStateFlow<Pais?>(null)
    val paisSeleccionado: StateFlow<Pais?> = _paisSeleccionado
//Inicializo la informacion de los paises
    init {
        actualizarPaises()
    }
    //Inicializo las funciones que se van a usar en la pantalla
    fun updateHora(nuevaHora: Int) {
        _hora.value = nuevaHora
    }

    fun updateMinutos(nuevosMinutos: Int) {
        _minutos.value = nuevosMinutos
    }

    private fun actualizarPaises() {
        val nuevaLista = listOf(
            Pais("Madrid", "España", R.drawable.madrid, 0),
            Pais("Paris", "Francia", R.drawable.paris, 0),
            Pais("Londres", "Reino Unido", R.drawable.londres, -1),
            Pais("Porto Alegre", "Brasil", R.drawable.puerto_alegre, -4),
            Pais("Acapulco", "México", R.drawable.acapulco, -7),
            Pais("Vancouver", "Canadá", R.drawable.vancouver, -9),
            Pais("Houston", "Estados Unidos", R.drawable.houston, -7),
            Pais("Casablanca", "Marruecos", R.drawable.casablanca, 0),
            Pais("Osaka", "Japón", R.drawable.osaka, +8),
            Pais("Melbourne", "Australia", R.drawable.melbourne, +10),
            Pais("Ankara", "Turquía", R.drawable.ankara, +2),
            Pais("Dubai", "Emiratos Árabes Unidos", R.drawable.dubai, +3)
        )
        _paises.value = nuevaLista
    }

    fun seleccionarPais(pais: Pais) {
        _paisSeleccionado.value = pais
    }

    fun calcularHoraLocal(baseHora: Int, diferencia: Int): String {
        val nuevaHora = (baseHora + diferencia + 24) % 24
        return nuevaHora.toString().padStart(2, '0')
    }
}
