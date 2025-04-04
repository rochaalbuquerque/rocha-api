package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

}
