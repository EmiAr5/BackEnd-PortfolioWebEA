package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Experiencia;
import com.portfolio.EmAr.repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    IExperienciaRepository expRepo;

    public List<Experiencia> list() {
        return expRepo.findAll();
    }

    public Optional<Experiencia> getOne(Long id) {
        return expRepo.findById(id);
    }

    public Optional<Experiencia> getByCompany(String compania) {
        return expRepo.findByCompania(compania);
    }

    public void crearExperiencia(Experiencia experiencia) {
        expRepo.save(experiencia);
    }

    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return expRepo.existsById(id);
    }

    public boolean existsByCompany(String compania) {
        return expRepo.existsByCompania(compania);
    }

}
