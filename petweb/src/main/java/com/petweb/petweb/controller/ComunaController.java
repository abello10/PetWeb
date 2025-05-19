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

import com.petweb.petweb.model.Comuna;
import com.petweb.petweb.service.ComunaService;

@RestController
@RequestMapping("/api/comunas/")
public class ComunaController {

@Autowired
    private ComunaService comunaService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Comuna> guardar(@RequestBody Comuna comuna){
        Comuna comunaNueva = comunaService.crearComuna(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(comunaNueva);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Comuna> ListarComunas(){
        return comunaService.ListarComunas();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Comuna> BuscarPorId(@PathVariable Integer id){
            return comunaService.BuscarPorId(id);
        }
        
    // Actualizar comunas :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarComuna(@RequestBody Comuna comuna){
                comunaService.actualizarComuna(comuna);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarComuna(@PathVariable Integer id){
            comunaService.eliminarComunaPorId(id);
        }

}
