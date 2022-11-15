package com.boomi.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boomi.project.exception.ResourceNotFoundException;
import com.boomi.project.model.Employee;
import com.boomi.project.model.FileData;
import com.boomi.project.service.ServiceInterface;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/boomi/project/")
public class EmployeeController {

	@Autowired
	private ServiceInterface service;
	
	@PostMapping("/signup")
	public String insert(@RequestBody Employee emp) {
		return service.insert(emp);
	}
	
	@GetMapping("/validate/{email}/{password}")
	public String validate(@PathVariable String email,@PathVariable String password) {
		if(email.isBlank() || password.isBlank())
			return "Fields are Blank";
		else
			return service.validate(email, password);
	}
	
	@PostMapping("/uploadFile/{email}/{password}")
	public boolean uploadFile(@PathVariable String email,@PathVariable String password,@RequestParam("Mfile")MultipartFile file) throws IllegalStateException,IOException{
		return service.uploadFile(email,password,file);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
		byte[] image = service.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("xml")).body(image);
	}
	
	@GetMapping("/byname/{email}/{password}/{name}")
	public ResponseEntity<List<FileData>> getByName(@PathVariable String email,@PathVariable String password,@PathVariable String name) {
		List<FileData> file = service.findByName(email,password,name);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with name :"+ name);
				}
		return ResponseEntity.ok(file);
	}
	
	@GetMapping("/bynames/{email}/{password}/{name}")
	public ResponseEntity<List<String>> getByNameS(@PathVariable String email,@PathVariable String password,@PathVariable String name) {
		List<String> file = service.findByNameS(email,password,name);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with Employee :"+ email);
				}
		return ResponseEntity.ok(file);
	}

	@GetMapping("/byaccount/{email}/{password}/{account}")
	public ResponseEntity<List<FileData>> getByAccount(@PathVariable String email,@PathVariable String password,@PathVariable String account) {
		List<FileData> file = service.findByAccount(email,password,account);
		System.out.println(file);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with account :"+ account);
				}
		return ResponseEntity.ok(file);
	}

	@GetMapping("/byaccounts/{email}/{password}/{account}")
	public ResponseEntity<List<String>> getByAccountS(@PathVariable String email,@PathVariable String password,@PathVariable String account) {
		List<String> file = service.findByAccountS(email,password,account);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with Employee :"+ email);
				}
		return ResponseEntity.ok(file);
	}
	
	@GetMapping("/bydate/{email}/{password}/{due_date}")
	public ResponseEntity<List<FileData>> getByDate(@PathVariable String email,@PathVariable String password,@PathVariable String due_date) {
		String s=due_date.substring(8, 10)+due_date.substring(4, 8)+due_date.substring(0, 4);
		List<FileData> file =service.findByDate(email,password,s);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with due_date :"+ due_date);
				}
		return ResponseEntity.ok(file);
	}
	
	@GetMapping("/bydates/{email}/{password}/{due_date}")
	public ResponseEntity<List<String>> getByDateS(@PathVariable String email,@PathVariable String password,@PathVariable String due_date) {
		List<String> file = service.findByDateS(email,password,due_date);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with Employee :"+ email);
				}
		return ResponseEntity.ok(file);
	}
	
	@GetMapping("/byemp/{email}/{password}")
	public ResponseEntity<List<FileData>> getByEmp(@PathVariable String email,@PathVariable String password) {
		List<FileData> file = service.findByEmp(email,password);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with Employee :"+ email);
				}
		return ResponseEntity.ok(file);
	}
	@GetMapping("/byemps/{email}/{password}")
	public ResponseEntity<List<String>> getByEmpS(@PathVariable String email,@PathVariable String password) {
		List<String> file = service.findByEmpS(email,password);
				if(file.isEmpty()) {
					throw new ResourceNotFoundException("Data not exist with Employee :"+ email);
				}
		return ResponseEntity.ok(file);
	}
}
