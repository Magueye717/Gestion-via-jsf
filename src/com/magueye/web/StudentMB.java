package com.magueye.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.magueye.dao.InterfaceStudent;
import com.magueye.entity.Student;


@ManagedBean(name="studentMB")
@RequestScoped
public class StudentMB {
	@EJB
	private InterfaceStudent dao;
    private int id;
	private String name;
	private String surname;
	private int number;
	private Student s = new Student();
	
	public String addStudent() {
		System.out.println("add");
		dao.addStudent(new Student(0, name, surname, number));
		return "successs";
	}
	
	public List<Student> ListStudent(){
		return dao.GetAllStudent();
	}
	
	public String remove(int id) {
		System.out.println("remove");
		dao.removeStudent(id);
		return "success";
	}
	//public String remove(int id) {
		//System.out.println("remove");
		//this.dao.removeStudent(id);
		//return "success";
	//}
	
	
	public String edit(Student s) {
		this.s=s;
		return "edit";
	}
	
	public String edit() {
		this.dao.updateStudent(this.s);
		return "edit";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

}
