package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Categoria;
import com.petweb.petweb.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;
    
    //Metodo para crear categoria C
    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepo.save(categoria);
    }

    //Metodo para listar las categorias R
    public List<Categoria> ListarCategorias(){
        return categoriaRepo.findAll();
    }

    //Actualizar nombre de categoria U
    public void actualizarCategoria(Categoria categoria){
        categoriaRepo.save(categoria);
    }

    //Eliminar categoria D
    public void eliminarCategoriaPorId(Integer id){
        categoriaRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Categoria> BuscarPorId(Integer id){
        return categoriaRepo.findById(id);
    }
}
