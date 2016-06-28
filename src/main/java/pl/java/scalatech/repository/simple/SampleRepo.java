package pl.java.scalatech.repository.simple;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.java.scalatech.domain.exercise.Department;
import pl.java.scalatech.domain.exercise.Employee;

@Repository
public class SampleRepo {

    @Autowired
    private EntityManager em;

    public List<Employee> findAll() { 
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee  e", Employee.class);
        return query.getResultList();
    }

    public List<Employee> findEmployeeWithName(final String name) {
        //TODO
        return null;
    }

    public List<Employee> findEmployees(String name, String deptName, String projectName, String city) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT DISTINCT e ");
        query.append("FROM Employee e LEFT JOIN e.projects p ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<>();
       //TODO

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }

        Query q = em.createQuery(query.toString());
       //TODO

        return q.getResultList();
    }

    public List<Employee> findEmp(String name, String deptName, String projectName, String city) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> emp = cq.from(Employee.class);

        cq.select(emp);
        cq.distinct(true);

        //tODO

        TypedQuery<Employee> query = em.createQuery(cq);
    
        
        //tODO
        return query.getResultList();
    }

    public List<Department> findDepartments() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> c = cb.createQuery(Department.class);

        TypedQuery<Department> query = em.createQuery(c);
        return query.getResultList();
    }


    public List<String> findEmpNames() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> c = cb.createQuery(String.class);
        Root<Employee> emp = c.from(Employee.class);
      
      //  c.distinct(false);

        //TODO
        return null;
    }

    public List<Tuple> findMultiplyExpressionTuple() {
        
       // c.select(cb.tuple(emp.get("id"), emp.get("name")));

        
        return null;
        /*
         * for (Tuple tuple : facade.findMultiplyExpressionTuple()) {
         * System.out.println(tuple.get(0) + " : " + tuple.get(1));
         * }
         */
    }

    public List<Object[]> findMultiSelect() {
        return null;
    }

    
    public List<Employee> fetchWithPhones() {
    return null;
    }

    public List<Employee> findWithDeptName(String deptName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> c = cb.createQuery(Employee.class);
        Root<Employee> emp = c.from(Employee.class);
      
    return null;
    }

    /*
     * SELECT e
     * FROM Employee e
     * WHERE e.address.state IN ('NY', 'CA')
     */
    public List<Employee> findInEmployee() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> c = cb.createQuery(Employee.class);
        Root<Employee> emp = c.from(Employee.class);
        //TODO
        return em.createQuery(c).getResultList();
    }

    /*
     * SELECT e
     * FROM Employee e
     * WHERE e.department IN
     * (SELECT DISTINCT d
     * FROM Department d JOIN d.employees de JOIN de.project p
     * WHERE p.name LIKE 'QA%')
     */
    public List<Employee> findInSubquery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Employee> c = cb.createQuery(Employee.class);
        Root<Employee> emp = c.from(Employee.class);
        //TODO
        return em.createQuery(c).getResultList();
    }

    public List<Object> findCoalesce() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> c = cb.createQuery();
        Root<Department> dept = c.from(Department.class);
        //TODO

        return em.createQuery(c).getResultList();
    }


}
