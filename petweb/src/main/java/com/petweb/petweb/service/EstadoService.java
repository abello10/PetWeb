package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Estado;
import com.petweb.petweb.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepo;
    
    //Metodo para crear estados C
    public Estado crearEstado(Estado estado){
        return estadoRepo.save(estado);
    }

    //Metodo para listar los estados R
    public List<Estado> ListarEstados(){
        return estadoRepo.findAll();
    }

    //Actualizar nombre de estado U
    public void actualizarEstado(Estado estado){
        estadoRepo.save(estado);
    }

    //Eliminar estado D
    public void eliminarEstadoPorId(Integer id){
        estadoRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Estado> BuscarPorId(Integer id){
        return estadoRepo.findById(id);

    }
}