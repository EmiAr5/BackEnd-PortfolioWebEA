package com.portfolio.EmAr.service;

import com.portfolio.EmAr.model.Hardskill;
import com.portfolio.EmAr.repository.HardskillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardskillService {

    @Autowired
    HardskillRepository hardskillRepo;

    public List<Hardskill> list() {
        return hardskillRepo.findAll();
    }

    public Optional<Hardskill> getOne(Long id) {
        return hardskillRepo.findById(id);
    }

    public Optional<Hardskill> getByNombre(String nombre) {
        return hardskillRepo.findByNombre(nombre);
    }

    public void crearHardskill(Hardskill hardskill) {
        hardskillRepo.save(hardskill);
    }

    public void borrarHardskill(Long id) {
        hardskillRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return hardskillRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return hardskillRepo.existsByNombre(nombre);
    }
}
