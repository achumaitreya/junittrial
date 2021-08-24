package com.hibernate.locking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="employee")
@DynamicUpdate(value=true)
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String desig, String dept, int sal) {
		super();
		this.name = name;
		this.desig = desig;
		this.dept = dept;
		this.sal = sal;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 
    private String name;
 
    private String desig;
 
    private String dept;
 
    private int sal;
    @Version
    private long version;
    
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
 
    public String getDesig() {
        return desig;
    }
 
    public void setDesig(String desig) {
        this.desig = desig;
    }
 
    public String getDept() {
        return dept;
    }
 
    public void setDept(String dept) {
        this.dept = dept;
    }
 
    public int getSal() {
        return sal;
    }
 
    public void setSal(int sal) {
        this.sal = sal;
    }
 
    public long getVersion() {
        return version;
    }
 
    public void setVersion(long version) {
        this.version = version;
    }
    

}
