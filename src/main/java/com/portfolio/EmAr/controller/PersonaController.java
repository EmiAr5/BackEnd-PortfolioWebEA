package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.PersonaDto;
import com.portfolio.EmAr.model.Persona;
import com.portfolio.EmAr.service.PersonaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://portfoliowebemar.web.app")
public class PersonaController {

    @Autowired
    PersonaService perServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = perServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        if (!perServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = perServ.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/traer/perfil")
    public ResponseEntity<Persona> findPersona() {
        Persona persona;
        persona = perServ.getOne((long) 1).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public ResponseEntity<?> create(@RequestBody PersonaDto dtoPersona) {
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtoPersona.getNombre(),
                dtoPersona.getApellido(),
                dtoPersona.getAcercade(),
                dtoPersona.getFechanac(),
                dtoPersona.getCelular(),
                dtoPersona.getEmail(),
                dtoPersona.getOcupacion(),
                dtoPersona.getPaisresidencia(),
                dtoPersona.getUrlfoto(),
                dtoPersona.getUrlbanner());
        perServ.crearPersona(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable("id") Long id) {
        if (!perServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        perServ.borrarPersona(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody PersonaDto dtoPersona) {
        if (!perServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = perServ.getOne(id).get();
        persona.setAcercade(dtoPersona.getAcercade());
        persona.setApellido(dtoPersona.getApellido());
        persona.setCelular(dtoPersona.getCelular());
        persona.setEmail(dtoPersona.getEmail());
        persona.setFechanac(dtoPersona.getFechanac());
        persona.setNombre(dtoPersona.getNombre());
        persona.setOcupacion(dtoPersona.getOcupacion());
        persona.setPaisresidencia(dtoPersona.getPaisresidencia());
        persona.setUrlbanner(dtoPersona.getUrlbanner());
        persona.setUrlfoto(dtoPersona.getUrlfoto());

        perServ.crearPersona(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
