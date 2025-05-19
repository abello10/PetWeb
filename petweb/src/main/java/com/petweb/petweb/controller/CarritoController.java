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

import com.petweb.petweb.model.Carrito;
import com.petweb.petweb.service.CarritoService;

@RestController
@RequestMapping("/api/carritos/")
public class CarritoController {

@Autowired
    private CarritoService carritoService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Carrito> guardar(@RequestBody Carrito carrito){
        Carrito carritoNuevo = carritoService.crearCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(carritoNuevo);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Carrito> ListarCarrito(){
        return carritoService.ListarCarrito();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Carrito> BuscarPorId(@PathVariable Integer id){
            return carritoService.BuscarPorId(id);
        }
        
    // Actualizar carrito :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarCarrito(@RequestBody Carrito carrito){
                carritoService.actualizarCarrito(carrito);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarCarrito(@PathVariable Integer id){
            carritoService.eliminarCarritoPorId(id);
        }


}
