package com.utar.staff.model.sessionbean;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.entity.Office;

import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;

@Local
public interface StaffSessionBeanLocal {
    public List<Employee> getAllEmployees() throws EJBException;
    public List<Object[]> readOfficeEmp(String keyword, String direction) throws EJBException;
    public List<Employee> readJob(String keyword, String direction) throws EJBException;
    public List<Office> getAllOffice() throws EJBException;
    public Employee findEmployee(String id) throws EJBException;
    public void updateEmployee(String[] s) throws EJBException;
    public void deleteEmployee(String id) throws EJBException;
    public void addEmployee(String[] s) throws EJBException;
}
