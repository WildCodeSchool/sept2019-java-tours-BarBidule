package com.barbidule.repository;

import com.barbidule.entity.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des intervenants utilisant JPA
 */
public interface ActualiteRepository extends JpaRepository<Actualite, Integer> {


}