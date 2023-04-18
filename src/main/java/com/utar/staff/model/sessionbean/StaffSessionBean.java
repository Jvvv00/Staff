package com.utar.staff.model.sessionbean;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.entity.Office;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StaffSessionBean implements StaffSessionBeanLocal {
    @PersistenceContext(unitName = "Staff")
    EntityManager em;

    public List<Employee> getAllEmployees() throws EJBException {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    public List<Object[]> readOfficeEmp(String keyword, String direction) throws EJBException{
        Query q = null;
        direction = " " + direction;
        if (keyword.isEmpty()) {
            q=em.createNativeQuery("select o.officecode, o.city, e.firstname, e.lastname\n" +
                "from classicmodels.offices o, classicmodels.employees e\n" +
                "where o.officecode = e.officecode\n" +
                "order by o.officecode" + direction);
        } else {
            q = em.createNativeQuery("select o.officecode, o.city, e.firstname, e.lastname\n" +
                    "from classicmodels.offices o, classicmodels.employees e\n" +
                    "where o.officecode = e.officecode\n" +
                    "and concat(o.officecode,e.firstname,e.lastname,o.city) \n" +
                    "LIKE ? order by o.officecode" + direction);
            q.setParameter(1, "%" + keyword + "%");
        }
        List<Object[]> results = q.getResultList();
        List<Employee> emps = new ArrayList<>();
        for(Object[] result : results){
           Office off = new Office();
           Number offid = (Number) result[0];
           off.setId(offid.intValue());
           off.setCity((String) result[1]);

           Employee emp = new Employee();
           emp.setFirstname((String) result[2]);
           emp.setLastname((String) result[3]);

           emps.add(emp);
        }
        return results;
    }

    public List<Employee> readJob(String keyword, String direction) throws EJBException{
        Query q = null;
        direction = " " + direction;
        if (keyword.isEmpty()) {
        q= em.createNativeQuery("SELECT * FROM classicmodels.employees order by employeenumber" +direction, Employee.class);
        } else {
            q= em.createNativeQuery("SELECT * FROM classicmodels.employees e " +
                    "WHERE concat(e.employeenumber, e.jobtitle, e.firstname, e.lastname) \n" +
                    "LIKE ? order by e.employeenumber" + direction, Employee.class);
            q.setParameter(1, "%" + keyword + "%");
        }
        List<Employee> results=q.getResultList();
        return results;
    }

    public List<Office> getAllOffice() throws EJBException {
        return em.createNamedQuery("Office.findAll").getResultList();
    }

    public Employee findEmployee(String id) throws EJBException {
       Query q = em.createNamedQuery("Employee.findbyId");
        q.setParameter("id", Integer.valueOf(id));
        return (Employee) q.getSingleResult();
    }
        public void updateEmployee(String[] s) throws EJBException {

        Employee e = findEmployee(s[0]);
        e.setFirstname(s[1]);
        e.setLastname(s[2]);
        e.setExtension(s[3]);
        e.setEmail(s[4]);
        e.setJobtitle(s[5]);
        em.merge(e);
    }

    public void deleteEmployee(String id) throws EJBException {
        Employee e = findEmployee(id);
        em.remove(e);
    }

    public void addEmployee(String[] s) throws EJBException {
        Employee e = new Employee();
        e.setId(Integer.valueOf(s[0]));
        e.setFirstname(s[1]);
        e.setLastname(s[2]);
        e.setExtension(s[3]);
        e.setEmail(s[4]);
        e.setJobtitle(s[5]);
        Office office = em.find(Office.class, Integer.valueOf(s[6]));
        e.setOfficecode(office);
        e.setReportsto(s[7]);
        em.persist(e);
    }
}
