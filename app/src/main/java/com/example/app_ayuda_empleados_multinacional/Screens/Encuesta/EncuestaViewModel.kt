package com.example.app_ayuda_empleados_multinacional.Screens.Encuesta

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EncuestaViewModel: ViewModel() {
    //Inicializo variables
    private val _expandedRe = MutableStateFlow(true)
    val expandedRE = _expandedRe.asStateFlow()

    private val _expandedCo = MutableStateFlow(false)
    val expadedCo = _expandedCo.asStateFlow()

    private val _expandedHij = MutableStateFlow(false)
    val expadedHij = _expandedHij.asStateFlow()

    private val _Rescheck = MutableStateFlow(false)
    val Rescheck = _Rescheck.asStateFlow()

    private val _Cocheck = MutableStateFlow(false)
    val Cocheck= _Cocheck.asStateFlow()

    private val _Residencia = MutableStateFlow("Alquiler")
    val Residencia= _Residencia.asStateFlow()

    private val _Coche = MutableStateFlow("Compacto")
    val Coche= _Coche.asStateFlow()

    private val _Hijos = MutableStateFlow(0)
    val Hijos= _Hijos.asStateFlow()

    private val _send = MutableStateFlow(false)
    val send= _send.asStateFlow()

    fun updateResidencia(value: String) {
        _Residencia.value = value
    }
    fun updateCoche(value: String) {
        _Coche.value = value
    }
    fun updateHijos(value: Int) {
        _Hijos.value = value
    }

    fun toggleCheckRes() {
        _Rescheck.value = !_Rescheck.value
    }

    fun toggleSend() {
        _send.value = !_send.value
    }

    fun toggleCheckCo() {
        _Cocheck.value = !_Cocheck.value
    }

    fun ExpandRes() {
        _expandedRe.value = !_expandedRe.value
    }

    fun ExpandCo() {
        _expandedCo.value = !_expandedCo.value
    }

    fun ExpandHij() {
        _expandedHij.value = !_expandedHij.value
    }
}