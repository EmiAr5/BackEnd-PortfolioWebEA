package com.portfolio.EmAr.security.service;

import com.portfolio.EmAr.security.entity.Rol;
import com.portfolio.EmAr.security.enums.RolNombre;
import com.portfolio.EmAr.security.repository.RolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepo;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepo.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        rolRepo.save(rol);
    }
}
