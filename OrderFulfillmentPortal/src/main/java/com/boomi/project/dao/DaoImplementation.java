package com.boomi.project.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boomi.project.model.Employee;
import com.boomi.project.model.FileData;
import com.boomi.project.model.Mfile;
import com.boomi.project.repository.DataRepo;
import com.boomi.project.repository.EmployeeRepository;
import com.boomi.project.repository.FileRepo;

@Repository
public class DaoImplementation implements DaoInterface {
	
	@Autowired
	private DataRepo datarepo;
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private FileRepo filerepo;

	@Override
	public Employee validate(String email, String password) {
		return emprepo.getEmp(email, password);
	}

	@Override
	public void uploadFile(Mfile file1) {
		filerepo.save(file1);
	}

	@Override
	public byte[] downloadFile(String fileName) throws IOException {
		Optional<Mfile> imageObject = filerepo.findByName(fileName);
        if(!imageObject.isEmpty()) {
        String fullPath = imageObject.get().getFpath();
        return Files.readAllBytes(new File(fullPath).toPath());
        }
        else
        	System.out.println("no file");
		return null;
	}

	@Override
	public void save(FileData data) {
		
		datarepo.save(data);
	}

	@Override
	public List<FileData> findByName() {
		return datarepo.findAll();
	}

	@Override
	public List<FileData> findByAccount() {
		return datarepo.findAll();
	}

	@Override
	public List<FileData> findByDate() {
		return datarepo.findAll();
	}

	@Override
	public String insert(Employee emp) {
		List<Employee> emp1=emprepo.findAll(emp.getEmail(), emp.getPassword());
		if(emp.getName().isBlank() || emp.getEmail().isBlank() || emp.getPassword().isBlank())
			return "Fields are empty";
		if(emp1.isEmpty()) {
		if(emprepo.save(emp)!=null)
			return "Successfully Registered";
		else
			return "Unsuccessfull";
		}
		else
			return "Username/Email taken";
	}

	@Override
	public List<FileData> findByEmp() {
		return datarepo.findAll();
	}
}
