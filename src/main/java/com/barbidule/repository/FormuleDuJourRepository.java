package com.barbidule.repository;

import com.barbidule.entity.FormuleDuJour;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des ardoises utilisant JPA
 */
public interface FormuleDuJourRepository extends JpaRepository<FormuleDuJour, Integer> {


}