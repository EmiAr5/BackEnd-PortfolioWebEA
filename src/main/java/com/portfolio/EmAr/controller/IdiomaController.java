package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.IdiomaDto;
import com.portfolio.EmAr.model.Idioma;
import com.portfolio.EmAr.service.IdiomaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
@CrossOrigin(origins = "https://portfoliowebemar.web.app")
public class IdiomaController {

    @Autowired
    IdiomaService idiomaServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Idioma>> list() {
        List<Idioma> list = idiomaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id") Long id) {
        if (!idiomaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Idioma idioma = idiomaServ.getOne(id).get();
        return new ResponseEntity(idioma, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody IdiomaDto dtoIdioma) {
        if (StringUtils.isBlank(dtoIdioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre del idioma es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Idioma idioma = new Idioma(
                dtoIdioma.getNombre(),
                dtoIdioma.getEscritura(),
                dtoIdioma.getLectura(),
                dtoIdioma.getOralidad()
        );

        idiomaServ.crearIdioma(idioma);
        return new ResponseEntity(new Mensaje("Idioma creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSoftskill(@PathVariable("id") Long id) {
        if (!idiomaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        idiomaServ.borrarIdioma(id);
        return new ResponseEntity(new Mensaje("Idioma eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody IdiomaDto dtoIdioma) {
        if (!idiomaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoIdioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre del idioma es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Idioma idioma = idiomaServ.getOne(id).get();

        idioma.setNombre(dtoIdioma.getNombre());
        idioma.setEscritura(dtoIdioma.getEscritura());
        idioma.setLectura(dtoIdioma.getLectura());
        idioma.setOralidad(dtoIdioma.getOralidad());

        idiomaServ.crearIdioma(idioma);
        return new ResponseEntity(new Mensaje("Idioma actualizado"), HttpStatus.OK);
    }
}
