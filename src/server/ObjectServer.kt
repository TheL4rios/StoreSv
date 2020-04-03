package server

data class Products(val id : Int,
                    val name : String,
                    val description : String,
                    val longDescription : String,
                    val price : Float,
                    val imgUrl : String)
data class ResponseJson(val statusCode : Int, val payLoad : Any)