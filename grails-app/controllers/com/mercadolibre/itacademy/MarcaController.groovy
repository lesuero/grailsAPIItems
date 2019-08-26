package com.mercadolibre.itacademy

import grails.converters.JSON
import groovy.json.JsonSlurper

class MarcaController {

    def index() {
        render (Marca.list() as JSON)
    }
/*
    def show(){
        println("asdasdasd")
        def marcas = Marca.getAll()
        render (marcas as JSON)
    }
    def getArticulos(){
        def id = params.get(marca_id)
        def articulos = Articulo.findAllByMarca(Marca.findById(id))
        render (articulos as JSON)
    }*/
}
