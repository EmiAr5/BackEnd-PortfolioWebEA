package com.portfolio.EmAr.repository;

import com.portfolio.EmAr.model.Hardskill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardskillRepository extends JpaRepository<Hardskill, Long> {

    public Optional<Hardskill> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
