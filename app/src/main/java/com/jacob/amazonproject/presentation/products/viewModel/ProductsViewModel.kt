package com.jacob.amazonproject.presentation.products.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import com.jacob.amazonproject.data.utils.Configurations
import com.jacob.amazonproject.domain.useCases.GetMoviesPopularUseCase
import com.jacob.amazonproject.presentation.core.base.BaseViewModel
import com.jacob.amazonproject.presentation.products.model.DataProducts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(
    private val getMoviesPopularUseCase: GetMoviesPopularUseCase
): BaseViewModel(){
    val productL = MutableLiveData<List<DataProducts>>()
    var moviesPopularResponse:  MoviesPopularResponse? = null

    init {
        getProductWS()
        getMoviesPopular()
    }

    private fun getMoviesPopular() {
        job = CoroutineScope(Dispatchers.IO).launch {
            moviesPopularResponse = getMoviesPopularUseCase.invoke(
                apiKey = Configurations.MOVIE_API_KEY,
                page = 1,
                language = "es-MX"
            ).body()
            withContext(Dispatchers.Main){
                moviesPopularResponse
            }
        }
    }

    private fun getProductWS() {
        val productsVWM = listOf(
            DataProducts(R.drawable.samsung_galaxi_a10,"Samsung Galaxy A10s",
                4.0,
                "3633.35",
                "Marca\n\n" +
                        "SO\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \nalmacenamiento\n de la memoria\n\n" +
                        "Otras funciones\n de la cámara\n\n" +
                        "Tamaño de la \npantalla\n\n",
                "Samsung Electronics\n\n" +
                        "Android 9.0\n\n" +
                        "Negro\n\n" +
                        "T-Mobile\n\n\n" +
                        "Deslizador\n\n" +
                        "32 GB\n\n\n\n" +
                        "Trasera, Frontal\n\n\n" +
                        "6.2 Pulgadas\n\n"),
            DataProducts(R.drawable.tlc_50,"TCL 50",
                4.5,
                "8699.00",
                "Marca\n\n" +
                        "Resolución del \nescáner\n\n" +
                        "Tipo de\n conector\n\n" +
                        "Servicios de \nInternet compatibles\n\n" +
                        "Tamaño de la \npantalla",
                "TCL\n\n" +
                        "4K\n\n\n" +
                        "USB, Ethernet, Entrada RF, HDMI\n\n" +
                        "Alexa\n\n\n\n" +
                        "50 Pulgadas"),
            DataProducts(R.drawable.xiaomi_redmi9c,"Xiaomi Redmi 9C",
                4.5,
                "2950.99",
                "Marca\n\n" +
                        "Sistema operativo\n\n" +
                        "Color\n\n" +
                        "Capacidad de\n almacenamiento \nde la memoria\n\n" +
                        "Otras funciones de\n la cámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Tipo de conector\n\n",
                "Xiaomi\n\n" +
                        "Android\n\n" +
                        "Azul\n\n" +
                        "64 GB\n\n\n\n" +
                        "Trasera, Frontal\n\n\n" +
                        "6.5 Pulgadas\n\n\n" +
                        "Bluetooth, USB, NFC"),
            DataProducts(R.drawable.xiamo_redmi_9a,"XIAOMI REDMI 9A",
                4.5,
                "2469.00",
                "Marca\n\n" +
                        "SO\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de\n almacenamiento \nde la memoria\n\n" +
                        "Otras funciones\n de la cámara\n\n",
                "Xiaomi\n\n" +
                        "Android 10.0\n\n" +
                        "Azul\n\n" +
                        "Desbloqueado\n\n\n" +
                        "Smartphone\n\n" +
                        "2 GB\n\n\n\n" +
                        "Trasera, Frontal\n\n"),
            DataProducts(R.drawable.tv_samsung_crystal_4k,"Tv Samsung Crystal 4K",
                5.0,
                "8499.00",
                "Tipo de montaje\n\n" +
                        "Marca\n\n" +
                        "Resolución del \nescáner\n\n" +
                        "Tipo de conector\n\n" +
                        "Tecnología de la \npantalla\n",
                "Montaje en mesa\n\n" +
                        "SAMSUNG\n\n" +
                        "4K\n\n\n" +
                        "Bluetooth, HDMI\n\n" +
                        "LED"),
            DataProducts(R.drawable.samsung_amartphone_a11,"Samsung Galaxy A11",
                4.5,
                "2950.99",
                "Marca\n\n" +
                        "Sistema operativo\n\n" +
                        "Color\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \n almacenamiento \n de la memoria\n\n" +
                        "Otras funciones de la cámara\n\n" +
                        "Tecnología celular\n\n" +
                        "Tipo de pantalla\n\n" +
                        "Tecnología de conectividad\n\n" +
                        "Resolución",
                "SAMSUNG\n\n" +
                        "SisteAndroid 10.0\n\n" +
                        "Blanco\n\n" +
                        "Smartphone\n\n" +
                        "64 GB\n\n\n\n" +
                        "Frontal\n\n" +
                        "4G\n\n" +
                        "AMOLED\n\n" +
                        "USB\n\n" +
                        "1560 x 720"),
            DataProducts(R.drawable.hinsense,"Hisense",
                4.5,
                "9999.00",
                "Tipo de montaje\n\n" +
                        "Marca\n\n" +
                        "Resolución del\n escáner\n\n" +
                        "Tipo de\n conector\n\n\n" +
                        "Tecnología de la \npantalla\n\n",
                "Montaje en pared\n\n" +
                        "Hisense\n\n" +
                        "4K\n\n\n" +
                        "RCA, USB, Ethernet,\n Entrada RF, HDMI,\n Tecnología_inalámbrica\n\n" +
                        "LED"),
            DataProducts(R.drawable.hisense_43h6g,"Hisense 43H6G",
                4.5,
                "6986.00",
                "Tipo de montaje\n\n" +
                        "Marca\n\n" +
                        "Resolución del\n escáner\n\n" +
                        "Tipo de conector\n\n\n\n" +
                        "Tecnología de la \npantalla\n\n",
                "Montaje en mesa\n\n" +
                        "Hisense\n\n" +
                        "4K\n\n\n" +
                        "USB, Ethernet, \nLAN, HDMI, \nTecnología_inalámbrica\n\n" +
                        "LED"),
            DataProducts(R.drawable.lavadora_automatica_19kg,"Lavadora Automática 19 kg",
                4.5,
                "9697.06",
                "* Ahorra agua gracias a la tecnología Aqua Saver Green\n\n" +
                        "* Máxima limpieza y cuidado de las prendas, gracias al nuevo diseño del agitador\n\n" +
                        "* Lavado Express, ropa lista en 20 minutos",
                ""),
            DataProducts(R.drawable.samsung_galaxy_a32,"Samsung Galaxy A32",
                5.0,
                "5499.00",
                "Marca\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n\n" +
                        "Capacidad de \nalmacenamiento\n de la memoria\n\n" +
                        "Otras funciones de \nla cámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Tecnología celular\n\n" +
                        "Fabricante del CPU\n\n" +
                        "Tipo de conector\n\n" +
                        "Resolución del \nescáner",
                "SAMSUNG\n\n" +
                        "Azul (Awesome Blue)\n\n" +
                        "Todas las empresas \nde transportes\n\n\n" +
                        "128 GB\n\n\n\n" +
                        "Trasera, Frontal\n\n\n" +
                        "6.4 Pulgadas\n\n\n" +
                        "4G, 3G, 2G\n\n" +
                        "MediaTek\n\n" +
                        "Bluetooth\n\n" +
                        "1080 x 2400"),
            DataProducts(R.drawable.oster_6831_licuadora_vaso_vidrio_color_rojo,"Oster 6831 Licuadora 10V Vaso Vidrio, color rojo",
                4.5,
                "899.00",
                "Color\n\n" +
                        "Material\n\n" +
                        "Marca\n\n" +
                        "Dimensiones\n del artículo \nLargo \nx ancho x alto\n\n" +
                        "Potencia",
                "Rojo\n\n" +
                        "Metal\n\n" +
                        "Oster\n\n" +
                        "25.8 x 21.6 x 35.3 centimeters\n\n\n\n\n" +
                        "450 watts"),
            DataProducts(R.drawable.zte_blade_a5,"ZTE BLADE A5",
                4.5,
                "2178.00",
                "Marca\n\n" +
                        "SO\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \nalmacenamiento \nde la memoria\n\n" +
                        "Otras funciones \nde la cámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Entrada de \ninterfaz humana\n\n" +
                        "Tiempo de \nconversación \ntelefónica",
                "ZTE\n\n" +
                        "Android 9.0\n\n" +
                        "AZUL\n\n" +
                        "Todas las empresas \nde transportes\n\n" +
                        "Bar\n\n" +
                        "64 GB\n\n\n\n" +
                        "Rear, Front\n\n\n" +
                        "6.1 Pulgadas\n\n\n" +
                        "Microphone, Touch Screen\n\n\n" +
                        "10 Hours"),
            DataProducts(R.drawable.television_westinghouse,"Televisión Westinghouse",
                4.0,
                "3699.00",
                "Marca\n\n" +
                        "Resolución del \nescáner\n\n" +
                        "Tipo de conector\n\n" +
                        "Tecnología de la \npantalla\n\n" +
                        "Color",
                "Amazon Renewed\n\n" +
                        "720p\n\n\n" +
                        "VGA, USB, HDMI\n\n" +
                        "LED\n\n\n" +
                        "Negro"),
            DataProducts(R.drawable.iphone_12_pro,"iPhone 12 Pro",
                5.0,
                "37999.00",
                "Marca\n\n" +
                        "Sistema operativo\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \nalmacenamiento de\n la memoria\n\n" +
                        "Otras funciones de\n la cámara\n\n" +
                        "Tamaño de la pantalla\n\n" +
                        "Tecnología celular\n\n" +
                        "Tipo de pantalla",
                "Apple\n\n" +
                        "IOS\n\n" +
                        "Azul pacífico\n\n" +
                        "Todas las empresas \nde transportes\n\n\n" +
                        "Smartphone\n\n" +
                        "512 GB\n\n\n\n" +
                        "Frontal\n\n\n" +
                        "6.7 Pulgadas\n\n" +
                        "GSM\n\n" +
                        "LED"),
            DataProducts(R.drawable.xiaomi_redmi_note_10,"Xiaomi REDMI Note 10",
                4.5,
                "4318.00",
                "Marca\n\n" +
                        "Color\n\n" +
                        "Operador\n inalámbrico\n\n" +
                        "Capacidad de \nalmacenamiento\n de la memoria\n\n" +
                        "Otras funciones de \nla cámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Entrada de \ninterfaz humana\n\n" +
                        "Fabricante del CPU\n\n" +
                        "Tipo de conector\n\n" +
                        "Peso del producto",
                "Xiaomi\n\n" +
                        "Blanco\n\n" +
                        "Todas las empresas de\n transportes\n\n" +
                        "4 GB\n\n\n\n" +
                        "Frontal\n\n\n" +
                        "6.43 Pulgadas\n\n\n" +
                        "Dial, Microphone,\n Keypad, Touch Screen\n\n" +
                        "Qualcomm\n\n" +
                        "USB\n\n" +
                        "178.8 Gramos"),
            DataProducts(R.drawable.parrilla_grill_taurus,"Parrilla Grill Taurus Tostare 850W Antiadherente Acero",
                4.5,
                "511.07",
                "Color\n\n" +
                        "Material\n\n" +
                        "Marca\n\n" +
                        "Dimensiones del \nartículo Largo x \nancho x alto\n\n" +
                        "Peso del \nproducto",
                "Negro con acero\n\n" +
                        "Acero inoxidable\n\n" +
                        "Taurus\n\n" +
                        "27 x 9 x 24 centimeters\n\n\n\n" +
                        "1 Kilogramos"),
            DataProducts(R.drawable.jvc_tv_50,"JVC TV 50\" Ultra HD 4K (2160p) LED TV LT-50MAW500 (Renewed)",
                3.0,
                "6499.00",
                "Tipo de montaje\n\n" +
                        "Marca\n\n\n" +
                        "Resolución del\n escáner\n\n" +
                        "Tipo de conector\n\n" +
                        "Tecnología de la\n pantalla",
                "Montaje en mesa, Montaje\n en pared\n\n" +
                        "Amazon Renewed\n\n" +
                        "4K\n\n\n" +
                        "HDMI\n\n" +
                        "LED"),
            DataProducts(R.drawable.refrigerador_automatico,"Mabe RMA1025VMXE0 Refrigerador Automático",
                4.5,
                "7999.00",
                "Color\n\n" +
                        "Tipo de \nacabado\n\n" +
                        "Marca\n\n" +
                        "Nombre del \nmodelo\n\n" +
                        "Patrón\n\n" +
                        "Energy Star\n\n" +
                        "Dimensiones \ndel artículo \nLargo x\n ancho x alto\n\n" +
                        "Tipo de \nbloqueo\n\n" +
                        "Refrigerante\n\n" +
                        "Capacidad",
                "Grafito\n\n" +
                        "Brillante\n\n\n" +
                        "Mabe\n\n" +
                        "RMA1025VMXE0\n\n\n" +
                        "Sólido\n\n" +
                        "2 Star\n\n" +
                        "65.1 x 55.5 x 166.8 centimeters\n\n\n\n\n" +
                        "Cerradura de puerta\n disponible\n\n" +
                        "R-134A\n\n" +
                        "10 Cubic Feet"),
            DataProducts(R.drawable.moto_g8_power_lite,"Moto G8 Power Lite",
                4.5,
                "3575.25",
                "Marca\n\n" +
                        "SO\n\n" +
                        "Color\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \nalmacenamiento\n de la memoria\n\n" +
                        "Otras funciones\n de la cámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Tecnología\n celular\n\n" +
                        "Tipo de pantalla\n\n" +
                        "Fabricante del\n CPU",
                "Motorola\n\n" +
                        "Android 9.0\n\n" +
                        "Turquesa\n\n" +
                        "Smartphone\n\n" +
                        "64 GB\n\n\n\n" +
                        "Trasera, Frontal\n\n\n" +
                        "6 Pulgadas\n\n\n" +
                        "4G\n\n\n" +
                        "LED\n\n" +
                        "MediaTek"),
            DataProducts(R.drawable.zte_blade_v20,"ZTE Blade V20",
                4.5,
                "3499.00",
                "Marca\n\n" +
                        "SO\n\n" +
                        "Color\n\n" +
                        "Operador \ninalámbrico\n\n" +
                        "Factor de forma\n\n" +
                        "Capacidad de \nalmacenamiento \nde la memoria\n\n" +
                        "Otras funciones de la \ncámara\n\n" +
                        "Tamaño de la \npantalla\n\n" +
                        "Entrada de interfaz\n humana\n\n" +
                        "Tiempo de conversación telefónica",
                "ZTE\n\n" +
                        "Android 10.0\n\n" +
                        "AZUL\n\n" +
                        "Todas las empresas \nde transportes\n\n" +
                        "Bar\n\n" +
                        "128 GB\n\n\n\n" +
                        "Rear, Front\n\n\n" +
                        "6.82 Pulgadas\n\n" +
                        "Microphone, Touch Screen\n\n\n" +
                        "10 Hours"),
            DataProducts(R.drawable.horno_de_microondas,"Horno de Microondas",
                4.5,
                "2326.99",
                "Nombre del\n modelo\n\n" +
                        "Marca\n\n" +
                        "Color\n\n" +
                        "Material\n\n" +
                        "Tipo de instalación\n\n" +
                        "Dimensiones del\n artículo Largo x\n ancho x alto\n\n\n" +
                        "Peso del producto\n\n" +
                        "Voltaje",
                "56300D1\n\n\n" +
                        "Whirlpool\n\n" +
                        "Gris\n\n" +
                        "Polycarbonate\n\n" +
                        "Incorporado\n\n" +
                        "53.9 x 42.3 x 30 centimeters\n\n\n\n\n" +
                        "12 Kilogramos\n\n" +
                        "240 Voltios"),
            DataProducts(R.drawable.quemadores_empotrable_hogar,"Quemadores Empotrable Hogar Cocina Gas Lp Gas Natural",
                4.0,
                "3599.00",
                "*¡GUTSTARK PARRILLA ELÉCTRICA5 QUEMADORES! Cuenta con encendido electrónico.\n\n" +
                        "*¡DISEÑO ELEGANTE! Fabricado con acero inoxidable y 5 quemadores de hierro.\n\n" +
                        "*¡EXCELENTE PARA USO CASERO! Puede utilizar gas LP o natural, solo debe cambiar el tipo de espreas para cada tipo de gas (las espreas ya vienen incluidas).\n\n" +
                        "*¡FÁCIL DE CONECTAR! No se requiere de herramientas para su instalación.\n\n" +
                        "*¡NO OCUPA MUCHO ESPACIO! Diseño de 76 X 50 X 11.50 cm.",
                ""),
            DataProducts(R.drawable.pared_tv,"Centro de Entretenimiento Panel Premium para Pared TV hasta 75 Pulgadas",
                3.5,
                "9499.0",
                "*Terminación laqueada en Blanco / amaderada en Natural\n\n" +
                        "*Tamaño 120 cm hasta TV 47\" / Tamaño 180 cm hasta TV 60 / Tamaño 220 cm hasta TV 75\n\n" +
                        "*Medidas del mueble Armado: Altura: 1611 mm / Profundidad: 389 mm / Ancho: 1200 mm (CITY 120cm) / Ancho: 1837 mm (CITY 180cm) / Ancho: 2197 mm (CITY 220cm)\n\n" +
                        "*Terminación laqueada en Blanco / amaderada en Natural\n\n" +
                        "*Puerta batiente con Bisagras de puerta fabricadas en acero de 35 mm.",
                ""),
            DataProducts(R.drawable.sarten_electrico,"Sarten Eléctrico",
                4.5,
                "715.00",
                "Nombre del modelo\n\n" +
                        "Material\n\n" +
                        "Marca\n\n" +
                        "Color\n\n" +
                        "Dimensiones \ndel artículo \nLargo x ancho \nx alto",
                "CKSTSK1712013\n\n" +
                        "Steel\n\n" +
                        "Oster\n\n" +
                        "Negro\n\n" +
                        "39 x 16 x 44 centimeters"),
            DataProducts(R.drawable.horno_empotrable_de_gas,"Horno Empotrable de gas",
                4.5,
                "8699.00",
                "* HORNO DE GAS (solo quemador inferior) 120V, 60Hz, 60cm de gran cavidad 67L\n\n" +
                        "* Control de mando mecánico Luz en el interior. Medidas 60cm x 60cm x 60cm\n\n" +
                        "* Temporizador mecánico de 60 minutos Válvula de seguridad europea\n\n" +
                        "* Ventilación tangencia y ventilador de convección\n\n" +
                        "* Puerta de vidrios de doble capa sin revestimiento Esmalte negro, fácil de limpiar la cavidad 1 bandeja de comida profunda 1 estante grande",
                ""),
            DataProducts(R.drawable.cable_usb_c,"Cable USB C",
                5.0,
                "429.00",
                "Dispositivos\n compatibles\n\n" +
                        "Marca\n\n" +
                        "Tipo de conector\n\n" +
                        "Velocidad de \ntransferencia de datos",
                "Tableta, Portátil, Smartphone\n\n" +
                        "UGREEN\n\n" +
                        "USB, Lightning\n\n" +
                        "480 Megabits Per Second"),
            DataProducts(R.drawable.clip_total,"CLIP TOTAL",
                4.5,
                "3599.00",
                "Marca\n\n" +
                        "Tecnología de\n impresión\n\n" +
                        "Color\n\n" +
                        "Peso del producto\n\n" +
                        "Sistema operativo\n\n",
                "Clip\n\n" +
                        "Térmica\n\n\n" +
                        "Naranja\n\n" +
                        "417 Gramos\n\n" +
                        "Android"),
            DataProducts(R.drawable.audifonos_inalambricos,"Audifonos inalámbricos",
                5.0,
                "560.99",
                "Característica\n especial\n\n" +
                        "Tipo de conector\n\n" +
                        "Marca\n\n" +
                        "Tecnología de \ncomunicación \ninalámbrica\n\n" +
                        "Control de ruido",
                "Ligero, Cancelación de Ruido, \nBluetooth, Inalámbrico\n\n" +
                        "Bluetooth\n\n" +
                        "Dudios\n\n" +
                        "Bluetooth\n\n\n\n" +
                        "Isolation acoustique"),
            DataProducts(R.drawable.tripode_con_bluetooth_remoto,"Eocean Palo Selfie Trípode con Bluetooth Remoto",
                4.5,
                "699.00",
                "Marca\n\n" +
                        "Material\n\n" +
                        "Color\n\n" +
                        "Límite de peso\n\n" +
                        "Peso del producto",
                "Eocean\n\n" +
                        "Aluminio\n\n" +
                        "Black\n\n" +
                        "1 Kilogramos\n\n" +
                        "260 Gramos"),
            DataProducts(R.drawable.steelpro_autoestereo,"Steelpro Autoestereo",
                3.5,
                "2860.00",
                "---AXEL-069 By STEELPRO Gama Alta 100w X 4 Max /50w x 4 RMS total---\n\n" +
                        "* Llamada por Voz Vía Siri o Google Voice - Control Total vía APP (Android / iOS) Descarga Gratuita Desde tu Celular - 10 Bandas de Ecualización desde la APP - 10 Bandas de Ecualización desde el Sistema - Control Total desde la APP\n\n" +
                        "* 2 DIN ( 7\" ancho x 4\" alto) - BLUETOOTH MANOS LIBRES - Push To talk Siri Google Voice - Triple Entrada para Cámara (Reversa, Frontal, Derecha) - LCD 6.2 - MP3 A 64GB/WMA /FM\n\n" +
                        "* Automática de Canales - Equalizador Prestablecido - Puerto USB 2.0 Carga Rápida - 24 memorias y Salida Auxiliar para aparatos personales - Mute, Random, Intro y Repetir - Salida Subwoofer Dedicada - RCA para Amplificador\n\n" +
                        "* 100x4 Watts Max - 50x4 RMS - ID3 Lectura en pantalla de títulos, álbum, artista - Multicolor Kameleon - Conexión de control al volante - Control Remoto Incluido + Cámara de reversa\n\n" +
                        "*  NOTA: La función MirrorLink del sistema AXEL-069 es compatible hasta ANDROID 10 y la actualización XR del Sistema IOS para equipos móviles Iphone.",
                ""),
        )
        productL.postValue(productsVWM)

    }
}