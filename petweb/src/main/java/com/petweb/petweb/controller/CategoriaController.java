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

import com.petweb.petweb.model.Categoria;
import com.petweb.petweb.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        Categoria categoriaNueva = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaNueva);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Categoria> ListarCategorias(){
        return categoriaService.ListarCategorias();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Categoria> BuscarPorId(@PathVariable Integer id){
            return categoriaService.BuscarPorId(id);
        }
        
    // Actualizar categorias :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarCategoria(@RequestBody Categoria categoria){
                categoriaService.actualizarCategoria(categoria);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarCategoria(@PathVariable Integer id){
            categoriaService.eliminarCategoriaPorId(id);
        }

}
