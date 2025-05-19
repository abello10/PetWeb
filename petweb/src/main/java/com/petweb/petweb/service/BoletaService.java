package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Boleta;
import com.petweb.petweb.repository.BoletaRepository;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepo;
    
    //Metodo para crear boletas -- Añadir validacion para que no se creen boletas sin productos o sin cliente
    public Boleta crearBoleta(Boleta boleta){
        return boletaRepo.save(boleta);
    }

    //Metodo para listar las boletas R
    public List<Boleta> ListarBoletas(){
        return boletaRepo.findAll();
    }

    //Actualizar nombre de boleta U
    public void actualizarBoleta(Boleta boleta){
        boletaRepo.save(boleta);
    }

    //Eliminar boleta D
    public void eliminarBoletaPorId(Integer id){
        boletaRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Boleta> BuscarPorId(Integer id){
        return boletaRepo.findById(id);
    }
}
