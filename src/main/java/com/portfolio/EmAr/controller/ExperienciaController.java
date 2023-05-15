package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.ExperienciaDto;
import com.portfolio.EmAr.model.Experiencia;
import com.portfolio.EmAr.service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://portfoliowebemar.web.app")
public class ExperienciaController {

    @Autowired
    ExperienciaService expServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto dtoExperiencia) {
        if (StringUtils.isBlank(dtoExperiencia.getCompania())) {
            return new ResponseEntity(new Mensaje("La compañia es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(
                dtoExperiencia.getUrllogocomp(),
                dtoExperiencia.getFechainicio(),
                dtoExperiencia.getFechafin(),
                dtoExperiencia.getPuesto(),
                dtoExperiencia.getCompania(),
                dtoExperiencia.getDescripciontrabajo()
        );

        expServ.crearExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        expServ.borrarExperiencia(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody ExperienciaDto dtoExperiencia) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoExperiencia.getCompania())) {
            return new ResponseEntity(new Mensaje("El nombre de la compañia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = expServ.getOne(id).get();

        experiencia.setUrllogocomp(dtoExperiencia.getUrllogocomp());
        experiencia.setFechafin(dtoExperiencia.getFechafin());
        experiencia.setFechainicio(dtoExperiencia.getFechainicio());
        experiencia.setPuesto(dtoExperiencia.getPuesto());
        experiencia.setCompania(dtoExperiencia.getCompania());
        experiencia.setDescripciontrabajo(dtoExperiencia.getDescripciontrabajo());

        expServ.crearExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
