package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.CommandTools;

@Repository
public interface CommandToolsRepository extends JpaRepository<CommandTools, Long> {

}
