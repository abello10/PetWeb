package com.petweb.petweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petweb.petweb.model.Cliente;
import com.petweb.petweb.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;
    
    //Metodo para crear clientes C
    public Cliente crearCliente(Cliente cliente){
        return clienteRepo.save(cliente);
    }

    //Metodo para listar las cliente R
    public List<Cliente> ListarClientes(){
        return clienteRepo.findAll();
    }

    //Actualizar nombre de cliente U
    public void actualizarCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    //Eliminar cliente D
    public void eliminarClientePorId(Integer id){
        clienteRepo.deleteById(id);
    }

    //Buscar por id. Optional sirve para que si no encuentra el ID nos lance una excepcion
    public Optional<Cliente> BuscarPorId(Integer id){
        return clienteRepo.findById(id);
    }

}
