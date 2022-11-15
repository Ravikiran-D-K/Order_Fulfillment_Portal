package com.boomi.project.dao;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.boomi.project.model.Employee;
import com.boomi.project.model.FileData;
import com.boomi.project.model.Mfile;

public interface DaoInterface {

	Employee validate(String email, String password);

	void uploadFile(Mfile file1);

	byte[] downloadFile(String fileName) throws IOException;

	void save(FileData data);

	List<FileData> findByName();

	List<FileData> findByAccount();

	List<FileData> findByDate();

	String insert(Employee emp);

	List<FileData> findByEmp();

}
