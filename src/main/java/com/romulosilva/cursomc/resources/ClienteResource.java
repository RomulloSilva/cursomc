package com.romulosilva.cursomc.resources;

import com.romulosilva.cursomc.domain.Cliente;
import com.romulosilva.cursomc.dto.ClienteDTO;
import com.romulosilva.cursomc.dto.ClienteNewDTO;
import com.romulosilva.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {

        Cliente obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
        Cliente obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
        Cliente obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {

        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(ClienteDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                     @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                     @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDTO = list.map(ClienteDTO::new);
        return ResponseEntity.ok(listDTO);
    }

}
