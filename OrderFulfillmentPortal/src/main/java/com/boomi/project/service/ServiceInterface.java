package com.boomi.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.boomi.project.model.Employee;
import com.boomi.project.model.FileData;

public interface ServiceInterface {

	public String validate(String email, String password);

	public boolean uploadFile(String email,String password,MultipartFile file) throws IllegalStateException, IOException;

	public byte[] downloadFile(String fileName) throws IOException;

	public List<FileData> findByName(String email,String password,String name);

	public List<FileData> findByAccount(String email,String password,String account);

	public List<FileData> findByDate(String email,String password,String due_date);

	public String insert(Employee emp);

	public List<FileData> findByEmp(String email,String password);

}
