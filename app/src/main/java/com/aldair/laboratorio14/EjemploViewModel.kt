package com.aldair.laboratorio14

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EjemploViewModel : ViewModel() {
    var mensaje by mutableStateOf("")

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.covidtracking.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val covidService = retrofit.create(CovidService::class.java)

    fun obtenerDatosParaFecha(fecha: Int) {
        viewModelScope.launch {
            mensaje = "Obteniendo datos para la fecha: $fecha"
            mensaje = try {
                val response = covidService.getCovidDataForDate(fecha)
                if (response.isNotEmpty()) {
                    val covidData = response.first()
                    "Positivos: ${covidData.positive}, Negativos: ${covidData.negative}"
                } else {
                    "No se encontraron datos para la fecha ingresada"
                }
            } catch (e: Exception) {
                "Error en la conexión: ${e.message}"
            }
        }
    }
}
