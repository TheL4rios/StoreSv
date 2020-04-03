package server

import io.ktor.server.netty.*
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.server.engine.*

fun main() {
    embeddedServer(Netty, 8080) {
        install(DefaultHeaders)
        install(CallLogging)

        routing {

            static("static"){
                files("img/")
            }

            getImage()
            listProducts()
        }
    }.start(wait = true)
}