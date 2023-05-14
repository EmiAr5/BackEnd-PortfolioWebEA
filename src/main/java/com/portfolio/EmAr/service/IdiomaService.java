package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Idioma;
import com.portfolio.EmAr.repository.IIdiomaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IdiomaService {

    @Autowired
    IIdiomaRepository idiomaRepo;

    public List<Idioma> list() {
        return idiomaRepo.findAll();
    }

    public Optional<Idioma> getOne(Long id) {
        return idiomaRepo.findById(id);
    }

    public Optional<Idioma> getByNombre(String nombre) {
        return idiomaRepo.findByNombre(nombre);
    }

    public void crearIdioma(Idioma idioma) {
        idiomaRepo.save(idioma);
    }

    public void borrarIdioma(Long id) {
        idiomaRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return idiomaRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return idiomaRepo.existsByNombre(nombre);
    }
}
