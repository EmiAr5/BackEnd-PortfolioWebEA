package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.EducacionDto;
import com.portfolio.EmAr.model.Educacion;
import com.portfolio.EmAr.service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portfolioemar.web.app")
public class EducacionController {

    @Autowired
    EducacionService eduServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public ResponseEntity<?> create(@RequestBody EducacionDto dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getInstitucion())) {
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                dtoEducacion.getUrllogoinst(),
                dtoEducacion.getInstitucion(),
                dtoEducacion.getFechainicio(),
                dtoEducacion.getFechafin(),
                dtoEducacion.getCarrera(),
                dtoEducacion.getTituloobtenido(),
                dtoEducacion.getPuntaje()
        );

        eduServ.crearEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        eduServ.borrarEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody EducacionDto dtoEducacion) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoEducacion.getInstitucion())) {
            return new ResponseEntity(new Mensaje("El nombre de la institucion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = eduServ.getOne(id).get();

        educacion.setUrllogoinst(dtoEducacion.getUrllogoinst());
        educacion.setInstitucion(dtoEducacion.getInstitucion());
        educacion.setFechainicio(dtoEducacion.getFechainicio());
        educacion.setFechafin(dtoEducacion.getFechafin());
        educacion.setCarrera(dtoEducacion.getCarrera());
        educacion.setTituloobtenido(dtoEducacion.getTituloobtenido());
        educacion.setPuntaje(dtoEducacion.getPuntaje());

        eduServ.crearEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
