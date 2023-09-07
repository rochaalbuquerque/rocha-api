package com.br.rocha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.rocha.entities.SQLScripts;

@Repository
public interface SQLScriptsRepository extends JpaRepository<SQLScripts, Long> {

	@Query("SELECT s FROM SQLScripts s WHERE s.name = :name")
	SQLScripts findScriptByName(@Param("name") String name);

}
