package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.HardskillDto;
import com.portfolio.EmAr.model.Hardskill;
import com.portfolio.EmAr.service.HardskillService;
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
@RequestMapping("/hardskill")
@CrossOrigin(origins = "http://localhost:4200")
public class HardskillController {

    @Autowired
    HardskillService hardskillServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Hardskill>> list() {
        List<Hardskill> list = hardskillServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Hardskill> getById(@PathVariable("id") Long id) {
        if (!hardskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Hardskill hardskill = hardskillServ.getOne(id).get();
        return new ResponseEntity(hardskill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public ResponseEntity<?> create(@RequestBody HardskillDto dtoHardskill) {
        if (StringUtils.isBlank(dtoHardskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Hardskill hardskill = new Hardskill(
                dtoHardskill.getNombre(),
                dtoHardskill.getPorcentaje()
        );

        hardskillServ.crearHardskill(hardskill);
        return new ResponseEntity(new Mensaje("Hard Skill creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarHardskill(@PathVariable("id") Long id) {
        if (!hardskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        hardskillServ.borrarHardskill(id);
        return new ResponseEntity(new Mensaje("Hard Skill eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody HardskillDto dtoHardskill) {
        if (!hardskillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoHardskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Hardskill hardskill = hardskillServ.getOne(id).get();

        hardskill.setNombre(dtoHardskill.getNombre());
        hardskill.setPorcentaje(dtoHardskill.getPorcentaje());

        hardskillServ.crearHardskill(hardskill);
        return new ResponseEntity(new Mensaje("Hard Skill actualizada"), HttpStatus.OK);
    }
}
