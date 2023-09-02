package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.SQLScripts;

@Repository
public interface SQLScriptsRepository extends JpaRepository<SQLScripts, Long> {

	SQLScripts findByName(String name);

}
