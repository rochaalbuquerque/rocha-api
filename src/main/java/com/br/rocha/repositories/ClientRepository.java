package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
