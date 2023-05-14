package com.portfolio.EmAr.security.service;

import com.portfolio.EmAr.security.entity.Usuario;
import com.portfolio.EmAr.security.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository userRepo;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return userRepo.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return userRepo.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        userRepo.save(usuario);
    }
}
