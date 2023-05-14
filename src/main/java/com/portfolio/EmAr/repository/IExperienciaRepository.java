package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {

    public Optional<Experiencia> findByCompania(String compania);

    public boolean existsByCompania(String compania);
}
