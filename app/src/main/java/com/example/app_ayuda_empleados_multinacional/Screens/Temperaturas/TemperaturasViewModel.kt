package com.example.app_ayuda_empleados_multinacional.Screens.Temperaturas
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TemperaturasViewModel : ViewModel() {
    private val _temperature = MutableStateFlow(-30f)
    val temperature = _temperature.asStateFlow()

    private val _isFahrenheit = MutableStateFlow(false)
    val isFahrenheit = _isFahrenheit.asStateFlow()

    private val _guardarTemp = MutableStateFlow<List<Float>>(emptyList())
    val guardarTemp = _guardarTemp.asStateFlow()

    fun updateTemperature(value: Float) {
        _temperature.value = value
    }

    fun toggleFahrenheit() {
        _isFahrenheit.value = !_isFahrenheit.value
    }

    fun saveTemperature() {
        _guardarTemp.value = _guardarTemp.value + _temperature.value
    }

    fun celsiusToFahrenheit(celsius: Int): Int {
        return ((celsius * 9 / 5) + 32)
    }
}
