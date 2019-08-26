package com.mercadolibre.itacademy

import grails.converters.JSON

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->

        def hotel1 = new Hotel(name: 'Hotel Vista').save(flush:true)
        def hotel2 = new Hotel(name: 'Premium Tower').save(flush:true)

        def marca1 = new Marca(name:'Suerobrand').save(flush:true)
        def marca2 = new Marca(name:'Ezebrand').save(flush:true)

        hotel1.addToRooms(new Room(number: 201)).save()
        hotel1.addToRooms(new Room(number: 202)).save()
        hotel1.addToRooms(new Room(number: 203)).save()
        hotel2.addToRooms(new Room(number: 301)).save()
        hotel2.addToRooms(new Room(number: 302)).save()
        hotel2.addToRooms(new Room(number: 303)).save()



        marca1.addToArticulos(new Articulo(name: 'Zapatatilla',picture: 'https://http2.mlstatic.com/zapatillas-hombre-salomon-crossamphibian-swift-D_NQ_NP_890423-MLA31549529365_072019-F.webp',total_items_in_this_category: 6)).save()
        marca1.addToArticulos(new Articulo(name: 'Gorra',picture:  'https://http2.mlstatic.com/gorra-goorin-bros-baseball-butch-trucker-oficial-unisex-D_NQ_NP_776581-MLA31116017132_062019-F.webp',total_items_in_this_category: 9)).save()
        marca1.addToArticulos(new Articulo(name: 'miBand 3',picture: 'https://http2.mlstatic.com/xiaomi-mi-band-3-reloj-inteligente-smartwatch-version-global-caja-sellada-original-en-espanol-deportivo-D_NQ_NP_640907-MLA31041782102_062019-F.webp',total_items_in_this_category: 33)).save()
        marca2.addToArticulos(new Articulo(name: 'Zoquete',picture: 'https://http2.mlstatic.com/oferta-imperdible-pack-de-12-pares-medias-soquetes-D_NQ_NP_884203-MLA31055194809_062019-F.webp',total_items_in_this_category: 1)).save()
        marca2.addToArticulos(new Articulo(name: 'Guantes',picture:  'https://http2.mlstatic.com/guantes-termicos-primera-piel-ski-trekking-running-softshell-D_NQ_NP_889387-MLA31009966864_062019-F.webp',total_items_in_this_category: 2)).save()
        marca2.addToArticulos(new Articulo(name: 'Pulsera',picture: 'https://http2.mlstatic.com/pulsera-hombre-pulsera-mujer-pulsera-roja-pulsera-suerte-aura-protectora-contra-envidia-amuleto-proteccion-hilo-rojo-D_NQ_NP_709069-MLA31247797637_062019-F.webp',total_items_in_this_category: 3)).save()



        marshaler()  //llamo al metodo
    }

    def destroy = {

    }

    private void marshaler() {
        //recibo objeto y le doy estructura json que quiero
        JSON.registerObjectMarshaller(Hotel) {
            hotel -> [
                    id: hotel.id,
                    name: hotel.name,
                    rooms: hotel.rooms.collect {
                        room -> [
                                id: room.id,
                                number: room.number
                        ]
                    }
            ]
        }





        JSON.registerObjectMarshaller(Room) {
            room -> [
                    id: room.id,
                    number: room.number,
                    date: new SimpleDateFormat("dd/MM/yyyy").format(new Date())
            ]
        }


        JSON.registerObjectMarshaller(Marca) {
            marca -> [
                    id: marca.id,
                    name: marca.name,
                    articulos: marca.articulos.collect {
                        articulo -> [
                                id: articulo.id.toString(),
                                picture: articulo.picture,
                                total_items_in_this_category: articulo.total_items_in_this_category,
                                children_categories: []

                        ]
                    }
            ]
        }


        JSON.registerObjectMarshaller(Articulo) {
            articulo -> [
                    id: articulo.id.toString(),
                    name: articulo.name,
                    picture: articulo.picture,
                    total_items_in_this_category: articulo.total_items_in_this_category,
                    children_categories: []
            ]
        }

    }


    //recibo objeto y le doy estructura json que quiero



}
