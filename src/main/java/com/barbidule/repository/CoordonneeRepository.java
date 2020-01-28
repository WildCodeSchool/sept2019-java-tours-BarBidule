package com.barbidule.repository;

import com.barbidule.entity.Coordonnee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des intervenants utilisant JPA
 */
public interface CoordonneeRepository extends JpaRepository<Coordonnee, Integer> {


}