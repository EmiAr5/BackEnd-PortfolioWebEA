package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Softskill;
import com.portfolio.EmAr.repository.ISoftskillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftskillService {

    @Autowired
    ISoftskillRepository softskillRepo;

    public List<Softskill> list() {
        return softskillRepo.findAll();
    }

    public Optional<Softskill> getOne(Long id) {
        return softskillRepo.findById(id);
    }

    public Optional<Softskill> getByNombre(String nombre) {
        return softskillRepo.findByNombre(nombre);
    }

    public void crearSoftskill(Softskill softskill) {
        softskillRepo.save(softskill);
    }

    public void borrarSoftskill(Long id) {
        softskillRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return softskillRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return softskillRepo.existsByNombre(nombre);
    }
}
