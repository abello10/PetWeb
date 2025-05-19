package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Existencias;
import com.petweb.petweb.repository.ExistenciasRepository;

@Service
public class ExistenciasService {

    @Autowired
    private ExistenciasRepository existenciasRepo;
    
    //Metodo para crear existencias C
    public Existencias crearExistencias(Existencias existencias){
        return existenciasRepo.save(existencias);
    }

    //Metodo para listar las existencias R
    public List<Existencias> ListarExistencias(){
        return existenciasRepo.findAll();
    }

    //Actualizar nombre de existencias U
    public void actualizarExistencias(Existencias existencias){
        existenciasRepo.save(existencias);
    }

    //Eliminar existencias D
    public void eliminarExistenciasPorId(Integer id){
        existenciasRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion (No error jeje)
    public Optional<Existencias> BuscarPorId(Integer id){
        return existenciasRepo.findById(id);
    }


}
