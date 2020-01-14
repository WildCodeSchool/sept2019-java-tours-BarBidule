package com.barbidule.barbidule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository de la première ardoise utilisant JPA
 */
public interface FormuleDuJourRepository extends JpaRepository<com.barbidule.barbidule.entity.FormuleDuJour, Integer> {


}