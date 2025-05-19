package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Producto;
import com.petweb.petweb.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepo;
    
    //Metodo para crear producto C
    public Producto crearProducto(Producto producto){
        return productoRepo.save(producto);
    }

    //Metodo para listar las productos R
    public List<Producto> ListarProductos(){
        return productoRepo.findAll();
    }

    //Actualizar nombre de producto U
    public void actualizarProducto(Producto producto){
        productoRepo.save(producto);
    }

    //Eliminar producto D
    public void eliminarProductoPorId(Integer id){
        productoRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Producto> BuscarPorId(Integer id){
        return productoRepo.findById(id);
    }

}
