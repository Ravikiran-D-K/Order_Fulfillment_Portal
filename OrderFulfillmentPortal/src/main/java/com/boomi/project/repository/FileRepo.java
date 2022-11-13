package com.boomi.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boomi.project.model.Employee;
import com.boomi.project.model.Mfile;


@Repository
public interface FileRepo extends JpaRepository<Mfile, Long>{

	
	@Query("SELECT t FROM Mfile t WHERE t.Fname=?1")
	Optional<Mfile> findByName(String fileName);

	@Query("SELECT t FROM Mfile t WHERE t.id=?1")
	Mfile getFile(Long id);

}
