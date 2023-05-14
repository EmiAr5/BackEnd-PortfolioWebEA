package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Persona;
import com.portfolio.EmAr.repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {

    @Autowired
    IPersonaRepository persoRepo;

    public List<Persona> list() {
        return persoRepo.findAll();
    }

    public Optional<Persona> getOne(Long id) {
        return persoRepo.findById(id);
    }

    public Optional<Persona> getByName(String nombre) {
        return persoRepo.findByNombre(nombre);
    }

    public void crearPersona(Persona persona) {
        persoRepo.save(persona);
    }

    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return persoRepo.existsById(id);
    }

    public boolean existsByName(String nombre) {
        return persoRepo.existsByNombre(nombre);
    }
}
