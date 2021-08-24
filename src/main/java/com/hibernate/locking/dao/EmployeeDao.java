package com.hibernate.locking.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hibernate.locking.model.*;
public interface EmployeeDao  extends JpaRepository<Employee,Integer>{
	/*
	 * @Modifying
	 * 
	 * @Query("update Employee e  set e.desig=:desig WHERE e.id=:id") void
	 * updateEmployee(@Param("id") int id,@Param("desig") String desig);
	 */
}
