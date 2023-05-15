package com.portfolio.EmAr.controller;

import com.portfolio.EmAr.dto.ProyectoDto;
import com.portfolio.EmAr.model.Proyecto;
import com.portfolio.EmAr.service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://portfolioemar.web.app")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto softskill = proyectoServ.getOne(id).get();
        return new ResponseEntity(softskill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody ProyectoDto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(
                dtoProyecto.getEnlace(),
                dtoProyecto.getUrlimagen(),
                dtoProyecto.getNombre(),
                dtoProyecto.getFechainicio(),
                dtoProyecto.getFechafin(),
                dtoProyecto.getDescripcion()
        );

        proyectoServ.crearProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id") Long id) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        proyectoServ.borrarProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody ProyectoDto dtoProyecto) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("Este id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = proyectoServ.getOne(id).get();

        proyecto.setEnlace(dtoProyecto.getEnlace());
        proyecto.setUrlimagen(dtoProyecto.getUrlimagen());
        proyecto.setNombre(dtoProyecto.getNombre());
        proyecto.setFechainicio(dtoProyecto.getFechainicio());
        proyecto.setFechafin(dtoProyecto.getFechafin());
        proyecto.setDescripcion(dtoProyecto.getDescripcion());

        proyectoServ.crearProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
