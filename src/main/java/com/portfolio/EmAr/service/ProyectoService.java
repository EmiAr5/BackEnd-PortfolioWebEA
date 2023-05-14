package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Proyecto;
import com.portfolio.EmAr.repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    IProyectoRepository proyectoRepo;

    public List<Proyecto> list() {
        return proyectoRepo.findAll();
    }

    public Optional<Proyecto> getOne(Long id) {
        return proyectoRepo.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return proyectoRepo.findByNombre(nombre);
    }

    public void crearProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    public void borrarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return proyectoRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return proyectoRepo.existsByNombre(nombre);
    }
}
