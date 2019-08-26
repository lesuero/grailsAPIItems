package com.mercadolibre.itacademy

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        /*
        "/marcas"(controller: "marca", parseRequest: true){
            action = [OPTIONS:"apiOptions", GET: "show", POST: "notSupported", PUT:"notSupported", DELETE:"notSupported"]
        }
        "/marcas/$marca_id/articulos/"(controller: "marca", parseRequest: true){
            action = [OPTIONS:"apiOptions", GET: "getArticulos", POST: "notSupported", PUT:"notSupported", DELETE:"notSupported"]
        }
*/

        "/marcas" (resources:"marca") {
            "/articulos" (resources: "articulo")
        }

        "/articulos" (resources: "articulo")

        "/marcas" (resources:"marca")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
