package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Softskill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftskillRepository extends JpaRepository<Softskill, Long> {

    public Optional<Softskill> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
