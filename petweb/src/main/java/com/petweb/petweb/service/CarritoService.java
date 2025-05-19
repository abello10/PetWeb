package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Carrito;
import com.petweb.petweb.repository.CarritoRepository;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepo;
    
    //Metodo para crear carrito C
    public Carrito crearCarrito(Carrito carrito){
        return carritoRepo.save(carrito);
    }

    //Metodo para listar las carrito R
    public List<Carrito> ListarCarrito(){
        return carritoRepo.findAll();
    }

    //Actualizar nombre de carrito U
    public void actualizarCarrito(Carrito carrito){
        carritoRepo.save(carrito);
    }

    //Eliminar carrito D
    public void eliminarCarritoPorId(Integer id){
        carritoRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Carrito> BuscarPorId(Integer id){
        return carritoRepo.findById(id);
    }
}
