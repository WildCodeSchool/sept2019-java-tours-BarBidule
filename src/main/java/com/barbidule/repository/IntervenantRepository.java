package com.barbidule.repository;

import com.barbidule.entity.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des intervenants utilisant JPA
 */
public interface IntervenantRepository extends JpaRepository<Intervenant, Integer> {


}