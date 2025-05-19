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

import com.petweb.petweb.model.Cliente;
import com.petweb.petweb.service.ClienteService;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController {

@Autowired
    private ClienteService clienteService;

    //Insertar info (post)
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){
        Cliente clienteNuevo = clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo);
    }

    //Mostrar los datos (Get)
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Cliente> ListarClientes(){
        return clienteService.ListarClientes();
    }

    //Listar-buscar por id
        @GetMapping(value = "listarPorId/{id}", headers = "Accept=application/json")
        public Optional<Cliente> BuscarPorId(@PathVariable Integer id){
            return clienteService.BuscarPorId(id);
        }
        
    // Actualizar clientes :D (put)
        @PutMapping(value = "actualizar", headers = "Accept=application/json")
            public void actualizarCliente(@RequestBody Cliente cliente){
                clienteService.actualizarCliente(cliente);
            }

    //Borrar (delete)
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
        public void eliminarCliente(@PathVariable Integer id){
            clienteService.eliminarClientePorId(id);
        }
}
