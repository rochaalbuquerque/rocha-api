package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.CommandCategories;

@Repository
public interface CommandCategoryRepository extends JpaRepository<CommandCategories, Long> {

}
