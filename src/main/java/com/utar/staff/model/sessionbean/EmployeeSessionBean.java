package com.utar.staff.model.sessionbean;

import com.utar.staff.model.entity.Employee;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal{
    @PersistenceContext(unitName = "Staff")
    EntityManager em;

    public List<Employee> getAllEmployees() throws EJBException {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }
    public List<Employee> readEmployee() throws
            EJBException {
        Query q = null;
        q = em.createNativeQuery("SELECT * FROM classicmodels.employees order by employenumber" , Employee.class);
        List<Employee> results = q.getResultList();
        return results;
    }
    public Employee findEmployee(String id) throws EJBException {
        Query q = em.createNamedQuery("Employee.findbyId");
        q.setParameter("id", Long.valueOf(id));
        return (Employee) q.getSingleResult();
    }
        public void updateEmployee(String[] s) throws EJBException {

        Employee e = findEmployee(s[0]);
        e.setFirstname(s[1]);
        e.setLastname(s[2]);
        em.merge(e);
    }

    public void deleteEmployee(String id) throws EJBException {
        Employee e = findEmployee(id);
        em.remove(e);
    }

    public void addEmployee(String[] s) throws EJBException {
        Employee e = new Employee();
        e.setFirstname(s[1]);
        e.setLastname(s[2]);
        em.persist(e);
    }
}
