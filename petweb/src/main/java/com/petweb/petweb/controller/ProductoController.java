package com.petweb.petweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petweb.petweb.model.Producto;
import com.petweb.petweb.service.ProductoService;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto productoNuevo = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Producto> ListarProductos(){
        return productoService.ListarProductos();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Producto> BuscarPorId(@PathVariable Integer id){
            return productoService.BuscarPorId(id);
        }
        
    // Actualizar productos :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarProducto(@RequestBody Producto producto){
                productoService.actualizarProducto(producto);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarProducto(@PathVariable Integer id){
            productoService.eliminarProductoPorId(id);
        }

}
