package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Educacion;
import com.portfolio.EmAr.repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository eduRepo;

    public List<Educacion> list() {
        return eduRepo.findAll();
    }

    public Optional<Educacion> getOne(Long id) {
        return eduRepo.findById(id);
    }

    public Optional<Educacion> getByInstitucion(String institucion) {
        return eduRepo.findByInstitucion(institucion);
    }

    public void crearEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }

    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return eduRepo.existsById(id);
    }

    public boolean existsByInstitucion(String institucion) {
        return eduRepo.existsByInstitucion(institucion);
    }
}
