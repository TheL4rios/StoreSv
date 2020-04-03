package server

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resolveResource
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route

fun Route.getImage()
{
    route("/", HttpMethod.Get){
        route("img", HttpMethod.Get){
            route("/"){
                handle {
                    call.respondText("404", ContentType.Text.Html, HttpStatusCode.NotFound)
                }
            }

            route("{image}"){
                handle {
                    val image = call.parameters["image"]
                    image?.let {
                        val imageAnswer = call.resolveResource("/img/$image")
                        if(imageAnswer != null)
                        {
                            call.respond(imageAnswer)
                        }
                        else
                        {
                            call.respondText("404", ContentType.Text.Html, HttpStatusCode.NotFound)
                        }
                    }
                }
            }
        }
    }
}