package com.example.app_ayuda_empleados_multinacional.Screens.Horas

import androidx.lifecycle.ViewModel
import com.example.app_ayuda_empleados_multinacional.R
import com.example.app_ayuda_empleados_multinacional.data.Pais
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HorasViewModel :ViewModel() {
    //Inicializo las variables que quiero que se mantengan
    private val _hora = MutableStateFlow(0)
    val hora: StateFlow<Int> = _hora

    private val _minutos = MutableStateFlow(0)
    val minutos: StateFlow<Int> = _minutos

    private val _paises = MutableStateFlow<List<Pais>>(emptyList())
    val paises: StateFlow<List<Pais>> = _paises

    private val _paisSeleccionado = MutableStateFlow<Pais?>(null)
    val paisSeleccionado: StateFlow<Pais?> = _paisSeleccionado
    //Pongo la informacion que haya al iniciarla aplicacion
    init {
        actualizarPaises()
    }
    //Declaro los diferentes metodos que se van a usar
    fun updateHora(nuevaHora: Int) {
        _hora.value = nuevaHora
    }
    fun updateMinutos(nuevosMinutos: Int) {
        _minutos.value = nuevosMinutos
    }

    private fun actualizarPaises() {
        val nuevaLista = mutableListOf<Pais>()
        val horaActual = _hora.value
        val minutosActuales = _minutos.value

        nuevaLista.add(Pais("Madrid", "España", R.drawable.madrid, hora = { horaActual }))
        nuevaLista.add(Pais("Paris", "Francia", R.drawable.paris, hora = { horaActual }))
        nuevaLista.add(Pais("Londres", "Reino Unido", R.drawable.londres, hora = { horaActual - 1 }))
        nuevaLista.add(Pais("Porto Alegre", "Brasil", R.drawable.puerto_alegre, hora = { horaActual - 4 }))
        nuevaLista.add(Pais("Acapulco", "México", R.drawable.acapulco, hora = { horaActual - 7 }))
        nuevaLista.add(Pais("Vancouver", "Canadá", R.drawable.vancouver, hora = { horaActual - 9 }))
        nuevaLista.add(Pais("Houston", "Estados Unidos", R.drawable.houston, hora = { horaActual - 7 }))
        nuevaLista.add(Pais("Casablanca", "Marruecos", R.drawable.casablanca, hora = { horaActual }))
        nuevaLista.add(Pais("Osaka", "Japón", R.drawable.osaka, hora = { horaActual + 8 }))
        nuevaLista.add(Pais("Melbourne", "Australia", R.drawable.melbourne, hora = { horaActual + 10 }))
        nuevaLista.add(Pais("Ankara", "Turquía", R.drawable.ankara, hora = { horaActual + 2 }))
        nuevaLista.add(Pais("Dubai", "Emiratos Árabes Unidos", R.drawable.dubai, hora = { horaActual + 3 }))

        _paises.value = nuevaLista
    }

    fun seleccionarPais(pais: Pais) {
        _paisSeleccionado.value = pais
    }
}