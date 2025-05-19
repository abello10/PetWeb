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

import com.petweb.petweb.model.Existencias;
import com.petweb.petweb.service.ExistenciasService;

@RestController
@RequestMapping("/api/existencias/")
public class ExistenciasController {

    @Autowired
    private ExistenciasService existenciasService;

        //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Existencias> guardar(@RequestBody Existencias existencias){
        Existencias existenciasNueva = existenciasService.crearExistencias(existencias);
        return ResponseEntity.status(HttpStatus.CREATED).body(existenciasNueva);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Existencias> ListarExistencias(){
        return existenciasService.ListarExistencias();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Existencias> BuscarPorId(@PathVariable Integer id){
            return existenciasService.BuscarPorId(id);
        }
        
    // Actualizar existencias :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarExistencias(@RequestBody Existencias existencias){
                existenciasService.actualizarExistencias(existencias);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarExistencias(@PathVariable Integer id){
            existenciasService.eliminarExistenciasPorId(id);
        }

}
