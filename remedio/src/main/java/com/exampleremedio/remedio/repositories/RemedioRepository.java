package com.exampleremedio.remedio.repositories;

import com.exampleremedio.remedio.entities.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
}
