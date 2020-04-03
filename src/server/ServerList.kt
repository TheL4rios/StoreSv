package server

import com.google.gson.GsonBuilder
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route

fun Route.listProducts()
{
    route("/list", HttpMethod.Get){
        val products = mutableListOf<Products>()
        (0..20).map {
            products.add(Products((Math.random() * 1000).toInt(),
                                    "Celular",
                                    "Celular Samsung",
                                    "Celular con alta capacidad de procesamiento",
                                    (3000f + Math.random() * 200).toFloat(),
                                    "http://192.168.1.93:8080/img/cel.jpeg"))

            products.add(Products((Math.random() * 1000).toInt(),
                                    "Auto",
                                    "Auto Ford",
                                    "Auto con 300 caballos de fuerza",
                                    (30000f + Math.random() * 200).toFloat(),
                                    "http://192.168.1.93:8080/img/auto.jpg"))

            products.add(Products((Math.random() * 1000).toInt(),
                                    "Case para celular",
                                    "Case para iphone",
                                    "Case con decoración",
                                    (30f + Math.random() * 200).toFloat(),
                                    "http://192.168.1.93:8080/img/case.jpeg"))

            products.add(Products((Math.random() * 1000).toInt(),
                                    "Pulseras",
                                    "Pulseras hechas a mano",
                                    "Pulseras artesanales",
                                    (200f + Math.random() * 10).toFloat(),
                                    "http://192.168.1.93:8080/img/pulseras.jpg"))
        }

        val payLoad = ResponseJson(HttpStatusCode.OK.value, products)
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonR = gson.toJson(payLoad)

        handle {
            call.respondText(jsonR, ContentType.Application.Json, HttpStatusCode.OK)
        }
    }
}