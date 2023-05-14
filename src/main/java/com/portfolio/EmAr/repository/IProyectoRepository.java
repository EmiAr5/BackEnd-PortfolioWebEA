package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {

    public Optional<Proyecto> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
