package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.SoftskillDto;
import com.portfolio.EmAr.model.Softskill;
import com.portfolio.EmAr.service.SoftskillService;
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
@RequestMapping("/softskill")
@CrossOrigin(origins = "https://portfoliowebemar.web.app")
public class SoftskillController {

    @Autowired
    SoftskillService softskillServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Softskill>> list() {
        List<Softskill> list = softskillServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Softskill> getById(@PathVariable("id") Long id) {
        if (!softskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Softskill softskill = softskillServ.getOne(id).get();
        return new ResponseEntity(softskill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public ResponseEntity<?> create(@RequestBody SoftskillDto dtoSoftskill) {
        if (StringUtils.isBlank(dtoSoftskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Softskill softskill = new Softskill(
                dtoSoftskill.getNombre(),
                dtoSoftskill.getPorcentaje()
        );

        softskillServ.crearSoftskill(softskill);
        return new ResponseEntity(new Mensaje("Soft Skill creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSoftskill(@PathVariable("id") Long id) {
        if (!softskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        softskillServ.borrarSoftskill(id);
        return new ResponseEntity(new Mensaje("Soft Skill eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody SoftskillDto dtoSoftskill) {
        if (!softskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoSoftskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Softskill softskill = softskillServ.getOne(id).get();

        softskill.setNombre(dtoSoftskill.getNombre());
        softskill.setPorcentaje(dtoSoftskill.getPorcentaje());

        softskillServ.crearSoftskill(softskill);
        return new ResponseEntity(new Mensaje("Soft Skill actualizada"), HttpStatus.OK);
    }
}
