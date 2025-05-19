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

import com.petweb.petweb.model.Estado;
import com.petweb.petweb.service.EstadoService;

@RestController
@RequestMapping("/api/estados/")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

        //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado){
        Estado estadoNuevo = estadoService.crearEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoNuevo);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Estado> ListarEstados(){
        return estadoService.ListarEstados();
    }

    //Listar-buscar por id
    @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
    public Optional<Estado> BuscarPorId(@PathVariable Integer id){
            return estadoService.BuscarPorId(id);
    }
        
    // Actualizar estados :D (put)
    @PutMapping(value = "actualizar", headers = "Accept=application/json")
    public void actualizarEstado(@RequestBody Estado estado){
        estadoService.actualizarEstado(estado);
    }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
    public void eliminarEstado(@PathVariable Integer id){
        estadoService.eliminarEstadoPorId(id);
    }

}
