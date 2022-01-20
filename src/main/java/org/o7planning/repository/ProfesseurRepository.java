package org.o7planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.o7planning.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

}
