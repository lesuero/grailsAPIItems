package com.mercadolibre.itacademy

import grails.rest.Resource

//@Resource(uri='/articulos')
class Articulo {

    String name
    String picture
    int total_items_in_this_category
    static belongsTo = [marca:Marca]

    static constraints = {

        name blank: false,nullable: false
        picture blank: false,nullable: false

    }

    /*Articulo(String name, String picture, int total_items_in_this_category) {
        this.name = name
        this.picture = picture
        this.total_items_in_this_category = total_items_in_this_category
    }*/
}
