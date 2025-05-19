package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import com.petweb.petweb.model.Comuna;
import com.petweb.petweb.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepo;
    
    //Metodo para crear comunas C
    public Comuna crearComuna(Comuna comuna){
        return comunaRepo.save(comuna);
    }

    //Metodo para listar las comunas R
    public List<Comuna> ListarComunas(){
        return comunaRepo.findAll();
    }

    //Actualizar nombre de comuna U
    public void actualizarComuna(Comuna comuna){
        comunaRepo.save(comuna);
    }

    //Eliminar comuna D
    public void eliminarComunaPorId(Integer id){
        comunaRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Comuna> BuscarPorId(Integer id){
        return comunaRepo.findById(id);
    }

}
