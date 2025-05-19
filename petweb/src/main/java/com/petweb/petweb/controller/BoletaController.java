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

import com.petweb.petweb.model.Boleta;
import com.petweb.petweb.service.BoletaService;

@RestController
@RequestMapping("/api/boletas/")
public class BoletaController {

@Autowired
    private BoletaService boletaService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Boleta> guardar(@RequestBody Boleta boleta){
        Boleta boletaNueva = boletaService.crearBoleta(boleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(boletaNueva);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Boleta> ListarBoletas(){
        return boletaService.ListarBoletas();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Boleta> BuscarPorId(@PathVariable Integer id){
            return boletaService.BuscarPorId(id);
        }
        
    // Actualizar boletas :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarBoleta(@RequestBody Boleta boleta){
                boletaService.actualizarBoleta(boleta);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarBoleta(@PathVariable Integer id){
            boletaService.eliminarBoletaPorId(id);
        }

}
