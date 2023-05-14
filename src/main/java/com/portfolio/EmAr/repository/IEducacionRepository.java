package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {

    public Optional<Educacion> findByInstitucion(String institucion);

    public boolean existsByInstitucion(String institucion);
}
