package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Bodega;
import com.petweb.petweb.repository.BodegaRepository;

@Service
public class BodegaService {

    @Autowired
    private BodegaRepository bodegaRepo;
    
    //Metodo para crear bodega C
    public Bodega crearBodega(Bodega bodega){
        return bodegaRepo.save(bodega);
    }

    //Metodo para listar las bodegas R
    public List<Bodega> ListarBodegas(){
        return bodegaRepo.findAll();
    }

    //Actualizar nombre de bodegas U
    public void actualizarBodega(Bodega bodega){
        bodegaRepo.save(bodega);
    }

    //Eliminar bodega D
    public void eliminarBodegaPorId(Integer id){
        bodegaRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Bodega> BuscarPorId(Integer id){
        return bodegaRepo.findById(id);
    }


}
