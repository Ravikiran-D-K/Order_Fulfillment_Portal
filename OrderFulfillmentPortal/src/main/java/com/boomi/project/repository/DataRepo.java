package com.boomi.project.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boomi.project.model.FileData;
import com.boomi.project.model.Mfile;


@Repository
public interface DataRepo extends JpaRepository<FileData, Long>{

//	@Query("SELECT t FROM Mfile t JOIN FETCH t.FileData where t.mfile_id=?1 and t.name=?2")
//	List<FileData> findByName(Long id, String name);
//	
//	@Query("SELECT t FROM Mfile t JOIN FETCH t.FileData where t.mfile_id=?1 and t.account=?2")
//	List<FileData> findByAccount(Long id,String account);
//	
//	@Query("SELECT t FROM Mfile t JOIN FETCH t.FileData where t.mfile_id=?1 and t.due_date=?2")
//	List<FileData> findByDate(Long id,String due_date);

//	@Query("SELECT t FROM FileData t where t.Email=?1 and t.Password=?2")
//	List<FileData> findByEmp(String email,String password);

}
