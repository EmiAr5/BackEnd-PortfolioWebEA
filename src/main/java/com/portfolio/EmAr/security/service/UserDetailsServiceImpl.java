package com.portfolio.EmAr.security.service;

import com.portfolio.EmAr.security.entity.Usuario;
import com.portfolio.EmAr.security.entity.UsuarioPrincipal;
import com.portfolio.EmAr.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = userRepo.findByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
