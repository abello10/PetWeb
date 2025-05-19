package com.petweb.petweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petweb.petweb.model.Region;
import com.petweb.petweb.service.RegionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/regiones/")
public class RegionController {

    @Autowired
    private RegionService regionService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Region> guardar(@RequestBody Region region){
        Region regionNueva = regionService.crearRegion(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(regionNueva);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Region> ListarRegiones(){
        return regionService.ListarRegiones();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Region> BuscarPorId(@PathVariable Integer id){
            return regionService.BuscarPorId(id);
        }
        
    // Actualizar regiones :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarRegion(@RequestBody Region region){
                regionService.actualizarRegion(region);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarRegion(@PathVariable Integer id){
            regionService.eliminarRegionPorId(id);
        }

    }
        
    
