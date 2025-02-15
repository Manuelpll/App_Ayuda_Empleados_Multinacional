package com.example.app_ayuda_empleados_multinacional.data

data class Contacto(val ciudad: String,val pais: String,val servicio: String,val telefono: String,val persona: PersonaDeContacto? = null)
