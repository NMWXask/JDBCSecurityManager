package org.example;

import org.example.dao.Dao;
import org.example.dao.DepartmentDaoImplJDBC;
import org.example.dao.SecurityDaoImplJDBC;

import java.sql.SQLException;


/*
Есть три основных метода, которые будем вызывать:
boolean execute() - create/drop - false он возвращает, когда все успешно выполнено, но нет какого - то ответа.
ResultSet executeQuery() - select - есть ответ, возвращает ResultSet
int executeUpdate() - update/insert/delete и т.д. - возвращает количество строк на которые повлиял запрос
 */

public class Main {


    public static void main(String[] args) throws SQLException {
        Dao jdbc = new SecurityDaoImplJDBC();
//        System.out.println(jdbc.getAll());
        SecurityDaoImplJDBC sqImpl = new SecurityDaoImplJDBC();

//        System.out.println(sqImpl.getBirthByMonth(2));
//        List<Security> list= jdbc.getBirthByMonth(7);



      var securityDao = new SecurityDaoImplJDBC();
//        Security testSecurityToSave = new Security();
//        testSecurityToSave.setFio("Севастьянов Владимир Юрьевич");
//        testSecurityToSave.setGender("M");
//        testSecurityToSave.setBirthDate(LocalDate.of(1993,5,17));
//        testSecurityToSave.setDepartment(2);
//        testSecurityToSave.setDateOfHealthPermit(LocalDate.of(2023,4,14));
//        testSecurityToSave.setDateOfKnowledgePermit(LocalDate.of(2023,11,16));
//        testSecurityToSave.setDateOfWeaponPermit(LocalDate.of(23,12,4));
//        System.out.println(securityDao.save(testSecurityToSave));
//        System.out.println(securityDao.delete(32));
//        System.out.println(securityDao.findById(13));

//        Security testSecurityByUpdate = securityDao.findById(33);
//        testSecurityByUpdate.setDepartment(2);
//        System.out.println(securityDao.update(testSecurityByUpdate));

//        System.out.println(securityDao.delete(33));

        //проверяем запросы по department
        Dao depJdbc = new DepartmentDaoImplJDBC();
        System.out.println(depJdbc.getAll());               // - запрос отработал успешно.
    }
}
