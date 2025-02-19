package com.example.app_ayuda_empleados_multinacional.Screens.Telefonos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.app_ayuda_empleados_multinacional.data.Contacto
import com.example.app_ayuda_empleados_multinacional.data.PersonaDeContacto

class TelefonosViewModel : ViewModel() {

    //Inicializo las variables que se van a guardar
    val ciudades = listOf(
        "Madrid", "París", "Londres", "Porto Alegre", "Acapulco",
        "Vancouver", "Houston", "Casablanca", "Osaka", "Melbourne", "Ankara", "Dubai"
    )

    val servicios = listOf(
        "Emergencias", "Policía", "Bomberos", "Oficina de Información y Turismo",
        "Ayuntamiento", "Servicio de Taxi", "Oficina"
    )


    private val contactos = listOf(
        // Madrid
        Contacto("Madrid", "España", "Emergencias", "112"),
        Contacto("Madrid", "España", "Policía", "091"),
        Contacto("Madrid", "España", "Bomberos", "080"),
        Contacto("Madrid", "España", "Oficina de Información y Turismo", "+34 914 201 314"),
        Contacto("Madrid", "España", "Ayuntamiento", "+34 915 883 300"),
        Contacto("Madrid", "España", "Servicio de Taxi", "+34 915 474 700"),
        Contacto("Madrid", "España", "Oficina", "+34 913 423 600",
            PersonaDeContacto("Antonio Avellaneda", "+34 913 423 634", "aavellaneda@splatnot.com")
        ),
        // París
        Contacto("París", "Francia", "Emergencias", "112"),
        Contacto("París", "Francia", "Policía", "17"),
        Contacto("París", "Francia", "Bomberos", "18"),
        Contacto("París", "Francia", "Oficina de Información y Turismo", "+33 1 49 52 42 63"),
        Contacto("París", "Francia", "Ayuntamiento", "+33 1 42 76 60 00"),
        Contacto("París", "Francia", "Servicio de Taxi", "+33 1 45 30 30 30"),
        Contacto("París", "Francia", "Oficina", "+33 1 45 26 20 30",
            PersonaDeContacto("François Merlin", "+33 1 45 26 22 46", "fmerlin@splatnot.com")
        ),
        // Londres
        Contacto("Londres", "Reino Unido", "Emergencias", "999"),
        Contacto("Londres", "Reino Unido", "Policía", "101"),
        Contacto("Londres", "Reino Unido", "Bomberos", "999"),
        Contacto("Londres", "Reino Unido", "Oficina de Información y Turismo", "+44 20 7344 1000"),
        Contacto("Londres", "Reino Unido", "Ayuntamiento", "+44 20 7983 4000"),
        Contacto("Londres", "Reino Unido", "Servicio de Taxi", "+44 20 7272 0272"),
        Contacto("Londres", "Reino Unido", "Oficina", "+44 20 2536 0200",
            PersonaDeContacto("Sarah Louise Taylor", "+44 20 2536 0232", "staylor@splatnot.com")
        ),
        // Acapulco
        Contacto("Acapulco", "México", "Emergencias", "911"),
        Contacto("Acapulco", "México", "Policía", "911"),
        Contacto("Acapulco", "México", "Bomberos", "911"),
        Contacto("Acapulco", "México", "Oficina de Información y Turismo", "+52 744 482 2855"),
        Contacto("Acapulco", "México", "Ayuntamiento", "+52 744 482 1400"),
        Contacto("Acapulco", "México", "Servicio de Taxi", "+52 744 485 1073"),
        Contacto("Acapulco", "México", "Oficina", "+52 744 779 1000",
            PersonaDeContacto("Antonio Avellaneda", "+52 744 779 1948", "aavellaneda@splatnot.com")
        ),
        // Osaka
        Contacto("Osaka", "Japón", "Emergencias", "110"),
        Contacto("Osaka", "Japón", "Policía", "110"),
        Contacto("Osaka", "Japón", "Bomberos", "119"),
        Contacto("Osaka", "Japón", "Oficina de Información y Turismo", "+81 6 6345 3301"),
        Contacto("Osaka", "Japón", "Ayuntamiento", "+81 6 6208 7171"),
        Contacto("Osaka", "Japón", "Servicio de Taxi", "+81 6 6345 1234"),
        Contacto("Osaka", "Japón", "Oficina", "+81 6 4882 6600",
            PersonaDeContacto("Takahashi Hiroshi", "+81 6 4882 6632", "thiroshi@splatnot.com")
        ),
        //Porto Alegre
        Contacto("Porto Alegre", "Brasil", "Emergencias", "190"),
        Contacto("Porto Alegre", "Brasil", "Policía", "190"),
        Contacto("Porto Alegre", "Brasil", "Bomberos", "193"),
        Contacto("Porto Alegre", "Brasil", "Oficina de Información y Turismo", "+55 51 3289 4285"),
        Contacto("Porto Alegre", "Brasil", "Ayuntamiento", "+55 51 3289 1027"),
        Contacto("Porto Alegre", "Brasil", "Servicio de Taxi", "+55 51 3211 1188"),
        Contacto("Porto Alegre", "Brasil", "Oficina", "+55 51 5644 1000",
        PersonaDeContacto("Maria Fernanda Oliveira Costa", "+55 51 5644 1688", "mfoliveira@splatnot.com")),
        //Vancouver
        Contacto("Vancouver", "Canadá", "Emergencias", "911"),
        Contacto("Vancouver", "Canadá", "Policía", "911"),
        Contacto("Vancouver", "Canadá", "Bomberos", "911"),
        Contacto("Vancouver", "Canadá", "Oficina de Información y Turismo", "+1 604 482 2888"),
        Contacto("Vancouver", "Canadá", "Ayuntamiento", "+1 604 873 7000"),
        Contacto("Vancouver", "Canadá", "Servicio de Taxi", "+1 604 681 1111"),
        Contacto("Vancouver", "Canadá", "Oficina", "+34 913 423 600",
            PersonaDeContacto("David Miller", "+34 913 423 634", "dmiller@splatnot.com")
        ),
        // Houston
        Contacto("Houston", "Estados Unidos", "Emergencias", "911"),
        Contacto("Houston", "Estados Unidos", "Policía", "713 884 3131"),
        Contacto("Houston", "Estados Unidos", "Bomberos", "911"),
        Contacto("Houston", "Estados Unidos", "Oficina de Información y Turismo", "+1 713 437 5240"),
        Contacto("Houston", "Estados Unidos", "Ayuntamiento", "+1 713 247 1000"),
        Contacto("Houston", "Estados Unidos", "Servicio de Taxi", "+1 713 236 1111"),
        Contacto("Houston", "Estados Unidos", "Oficina", "+1 713 555 1222",
            PersonaDeContacto("Robinson Hill", "+1 713 555 1291", "rhill@splatnot.com")
        ),
        // Casablanca
        Contacto("Casablanca", "Marruecos", "Emergencias", "19"),
        Contacto("Casablanca", "Marruecos", "Policía", "19"),
        Contacto("Casablanca", "Marruecos", "Bomberos", "15"),
        Contacto("Casablanca", "Marruecos", "Oficina de Información y Turismo", "+212 522 225 410"),
        Contacto("Casablanca", "Marruecos", "Ayuntamiento", "+212 522 235 157"),
        Contacto("Casablanca", "Marruecos", "Servicio de Taxi", "+212 522 252 014"),
        Contacto("Casablanca", "Marruecos", "Oficina", "+212 522 449 000",
            PersonaDeContacto("Ahmed Ben Youssef El Fassi", "+212 522 449 644", "abenyoussef@splatnot.com")
        ),
        // Melbourne
        Contacto("Melbourne", "Australia", "Emergencias", "000"),
        Contacto("Melbourne", "Australia", "Policía", "000"),
        Contacto("Melbourne", "Australia", "Bomberos", "000"),
        Contacto("Melbourne", "Australia", "Oficina de Información y Turismo", "+61 3 9658 9658"),
        Contacto("Melbourne", "Australia", "Ayuntamiento", "+61 3 9658 9658"),
        Contacto("Melbourne", "Australia", "Servicio de Taxi", "+61 3 8413 7300"),
        Contacto("Melbourne", "Australia", "Oficina", "+61 3 9974 9600",
            PersonaDeContacto("Emily Johnson", "+61 3 9974 9677", "ejohnson@splatnot.com")
        ),
        // Ankara
        Contacto("Ankara", "Turquía", "Emergencias", "112"),
        Contacto("Ankara", "Turquía", "Policía", "155"),
        Contacto("Ankara", "Turquía", "Bomberos", "110"),
        Contacto("Ankara", "Turquía", "Oficina de Información y Turismo", "+90 312 310 13 55"),
        Contacto("Ankara", "Turquía", "Ayuntamiento", "+90 312 507 10 00"),
        Contacto("Ankara", "Turquía", "Servicio de Taxi", "+90 312 444 75 47"),
        Contacto("Ankara", "Turquía", "Oficina", "+90 312 822 70 00",
            PersonaDeContacto("Elif Demir", "+90 312 822 70 94", "edemir@splatnot.com")
        ),
        // Dubai
        Contacto("Dubai", "Emiratos Árabes Unidos", "Emergencias", "999"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Policía", "999"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Bomberos", "997"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Oficina de Información y Turismo", "+971 4 201 5555"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Ayuntamiento", "+971 4 406 5555"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Servicio de Taxi", "+971 4 208 0808"),
        Contacto("Dubai", "Emiratos Árabes Unidos", "Oficina", "+971 4 495 7000",
            PersonaDeContacto("Khalid Al Maktoum", "+971 4 495 7556", "kalmaktoum@splatnot.com")
        )
    )

    var ciudadSeleccionada by mutableStateOf(ciudades.first())
    var servicioSeleccionado by mutableStateOf(servicios.first())

    //Inicializo las funciones que se van a usar en la pantalla
    fun cambiarCiudad(nuevaCiudad: String) {
        ciudadSeleccionada = nuevaCiudad
    }

    fun cambiarServicio(nuevoServicio: String) {
        servicioSeleccionado = nuevoServicio
    }

    val contactoActual: Contacto?
        get() = contactos.find { it.ciudad == ciudadSeleccionada && it.servicio == servicioSeleccionado }
}