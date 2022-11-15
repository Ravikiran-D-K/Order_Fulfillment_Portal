package com.boomi.project.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.boomi.project.dao.DaoInterface;
import com.boomi.project.model.Employee;
import com.boomi.project.model.FileData;
import com.boomi.project.model.Mfile;
import com.boomi.project.repository.DataRepo;
import com.boomi.project.repository.EmployeeRepository;
import com.boomi.project.repository.FileRepo;

@Service
public class ServiceImplementation implements ServiceInterface{

	@Autowired
	private DaoInterface dao;

	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private FileRepo filerepo;
	
	@Override
	public String validate(String email, String password) {
		Employee listStudent=  dao.validate(email, password);
		
		if(listStudent==null)
			return "Wrong email or password";
		else
			return "true";
	}
	
	private final String PATH = "F:\\";
	
	@Override
	public boolean uploadFile(String email,String password,MultipartFile file) throws IllegalStateException, IOException {
		int x=file.hashCode();
		String fullPath = PATH+x+file.getOriginalFilename();
		Mfile file1 = new Mfile();
		file1.setFname(x+file.getOriginalFilename());
		file1.setFpath(fullPath);
		Employee emp =emprepo.getEmp(email,password);
		file1.setEmlpoyee(emp);
		file.transferTo(new File(fullPath));
		 dao.uploadFile(file1);
		return uploadData(emp,file1.getId(),fullPath);
	}
	
	@Override
	public byte[] downloadFile(String fileName) throws IOException{
		return dao.downloadFile(fileName);
    }
	
	int c=0;
	public boolean uploadData(Employee emp,Long id,String file) {
		ArrayList<String> list=new ArrayList<>();
		try   
		{  
		SAXParserFactory factory = SAXParserFactory.newInstance();  
		SAXParser saxParser = factory.newSAXParser();  
		DefaultHandler handler = new DefaultHandler()   
		{  
		boolean account = false;  
		boolean due_date = false;  
		boolean id = false;  
		boolean category = false;  
		boolean name = false;  
		boolean quantity = false;  
		//parser starts parsing a specific element inside the document    
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException   
		{  
			if(c==9)
				c=3;
		System.out.println("Start Element :" + qName);
		c++;
		if(c==1 && !qName.equalsIgnoreCase("ORDER")) {
			c=-1;
			warning(qName+" not found");
		}
		if (qName.equalsIgnoreCase("ACCOUNT"))   
		{  
		account = true;  
		}
		else if(c==2 && !qName.equalsIgnoreCase("ACCOUNT"))
		 {
			c=-1;
			warning(qName+" not found");
		}
			
		if (qName.equalsIgnoreCase("DUE_DATE"))   
		{  
		due_date = true;  
		}
		else if(c==3 && !qName.equalsIgnoreCase("DUE_DATE"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		if(c==4 && !qName.equalsIgnoreCase("PRODUCT"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		
		if(qName.equalsIgnoreCase("Id"))  
		{  
		id=true;  
		}  
		else if(c==5 && !qName.equalsIgnoreCase("ID"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		if (qName.equalsIgnoreCase("CATEGORY"))   
		{  
		category = true;  
		}  
		else if(c==6 && !qName.equalsIgnoreCase("CATEGORY"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		if (qName.equalsIgnoreCase("NAME"))   
		{  
		name = true;  
		} 
		else if(c==7 && !qName.equalsIgnoreCase("NAME1"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		if (qName.equalsIgnoreCase("QUANTITY"))   
		{  
		quantity = true;  
		}  
		else if(c==8 && !qName.equalsIgnoreCase("QUANTITY"))
		 {
			c=-1;
			warning(qName+" not found");
		}
		}  
		//parser ends parsing the specific element inside the document  
		public void endElement(String uri, String localName, String qName) throws SAXException   
		{  
		System.out.println("End Element:" + qName);  
		if(c==2 && !qName.equalsIgnoreCase("ACCOUNT"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(c==3 && !qName.equalsIgnoreCase("DUE_DATE"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(c==5 && !qName.equalsIgnoreCase("ID"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(c==6 && !qName.equalsIgnoreCase("CATEGORY"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(c==7 && !qName.equalsIgnoreCase("NAME"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(c==8 && !qName.equalsIgnoreCase("QUANTITY"))
		{
			c=-1;
			warning(qName+" not found");
		}
		
		if(c==9 && !qName.equalsIgnoreCase("PRODUCT"))
		{
			c=-1;
			warning(qName+" not found");
		}
		if(qName.equalsIgnoreCase("QUANTITY"))
			c++;
		if(qName.equalsIgnoreCase("ORDER")) {
			c=10;
		}
		if(qName.equalsIgnoreCase("PRODUCT"))
			c++;
		}  
		//reads the text value of the currently parsed element 

		public void characters(char ch[], int start, int length) throws SAXException   
		{  
		if (account)   
		{  
		System.out.println("account : " + new String(ch, start, length));
		list.add( new String(ch, start, length));
		account = false;  
		}
		if (due_date)   
		{  
		System.out.println("due_date : " + new String(ch, start, length));  
		list.add( new String(ch, start, length));
		due_date = false;  
		}
		if (id)   
		{  
		System.out.println("ID : " + new String(ch, start, length));  
		list.add( new String(ch, start, length));
		id = false;  
		}  
		if (category)   
		{  
		System.out.println("category: " + new String(ch, start, length));
		list.add( new String(ch, start, length));
		category = false;  
		}  
		if (name)   
		{  
		System.out.println("name: " + new String(ch, start, length)); 
		list.add( new String(ch, start, length));
		name = false;  
		}  
		if (quantity)  
		{  
		System.out.println("quantity: " + new String(ch, start, length)); 
		list.add( new String(ch, start, length));
		quantity = false;  
		}  
		  
		}
		public void warning(String i) throws SAXException{
			throw new SAXException("Error "+i);
		}
		};  
		saxParser.parse(file, handler);  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}

		Mfile file2=filerepo.getFile(id);
		
		if(c==10) {
			String a=list.get(0);
			String b=list.get(1);
			int c=2;
			int i=(list.size()-2)/4;
			while(i!=0) {
			FileData data= new FileData();
			data.setAccount(a);
			data.setDue_date(b);
			data.setP_id(list.get(c++));
			data.setCategory(list.get(c++));
			data.setName(list.get(c++));
			data.setQuantity(Integer.parseInt(list.get(c++)));
			data.setEmployee(emp);
			//data.setMfile(file2);
			dao.save(data);
			
			i--;
			}
			return true;
		}
		if(c==-1)
			return false;
		
		return false;  
	}

	@Override
	public List<FileData> findByName(String email,String password,String name) {
		List<FileData> data= dao.findByName();
		List<FileData> data1=new ArrayList<>();
		int i=data.size(),a=0;
		while(i!=0) {
		if(data.get(a).getEmployee().getEmail().contentEquals(email) && data.get(a).getEmployee().getPassword().contentEquals(password)
				&& data.get(a).getName().contentEquals(name)) {
			data1.add(data.get(a));
			a++;
		}
		i--;
		}
		return data1;
		
	}

	@Override
	public List<FileData> findByAccount(String email,String password,String account) {
		List<FileData> data= dao.findByAccount();
		
		List<FileData> data1=new ArrayList<>();
		int i=data.size(),a=0;
		while(i!=0) {
		if(data.get(a).getEmployee().getEmail().contentEquals(email) && data.get(a).getEmployee().getPassword().contentEquals(password)
				&& data.get(a).getAccount().contentEquals(account)) {
			data1.add(data.get(a));
			a++;
		}
		i--;
		}
		return data1;
		}
	

	@Override
	public List<FileData> findByDate(String email,String password,String due_date) {
		List<FileData> data= dao.findByDate();
		
		List<FileData> data1=new ArrayList<>();
		int i=data.size(),a=0;
		while(i!=0) {
		if(data.get(a).getEmployee().getEmail().contentEquals(email) && data.get(a).getEmployee().getPassword().contentEquals(password)
				&& data.get(a).getDue_date().contentEquals(due_date)) {
			data1.add(data.get(a));
			a++;
		}
		i--;
		}
		return data1;
		}
	

	@Override
	public String insert(Employee emp) {
		return dao.insert(emp);
	}
	
	@Autowired
	private DataRepo datarepo;
	

	@Override
	public List<FileData> findByEmp(String email,String password) {
		List<FileData> data= dao.findByEmp();
		if(email.contentEquals("Admin@gmail.com") && password.contentEquals("Admin")) {
			return data;
		}
		else {
		List<FileData> data1=new ArrayList<>();
		int i=data.size(),a=0;
		while(i!=0) {
		if(data.get(a).getEmployee().getEmail().contentEquals(email) && data.get(a).getEmployee().getPassword().contentEquals(password)) {
			data1.add(data.get(a));
			a++;
		}
		i--;
		}
		return data1;
		}
	}
}
