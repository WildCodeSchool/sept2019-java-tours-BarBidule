package com.barbidule.repository;

import com.barbidule.entity.Actualite;
import com.barbidule.entity.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des intervenants utilisant JPA
 */
public interface CoordonneesRepository extends JpaRepository<Coordonnees, Integer> {


}