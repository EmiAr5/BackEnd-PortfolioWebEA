package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Idioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Long> {

    public Optional<Idioma> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
