package org.example.dao;

import org.example.entity.Department;
import org.example.exception.DaoException;
import org.example.query.SQLQuery;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImplJDBC implements Dao<Department, Integer> {
    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();

        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(SQLQuery.GET_ALL_DEPARTMENTS)) {

            var result = statement.executeQuery();

            while (result.next()){
                departments.add(
                        new Department(
                                result.getInt("id"),
                                result.getString("name")
                        )
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return departments;
    }

    @Override
    public Department save(Department department) {
        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(SQLQuery.SAVE_DEPARTMENT, Statement.RETURN_GENERATED_KEYS)) {//чтобы увидеть сгенерированные ключи.
            statement.setString(1,"name");

            statement.executeUpdate();

            var keys = statement.getGeneratedKeys();//Это Result Set , получим набор сгенерированных id.

            if(keys.next()){
                department.setId(keys.getInt("id"));
            }
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(SQLQuery.DELETE_DEPARTMENT)) {
            statement.setInt(1,id);

            return statement.executeUpdate()>1;//если больше 1 строчки проапдейтили, то он что то удалил.
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Department department) {
        try (var connection = ConnectionManager.open();
        var statement = connection.prepareStatement(SQLQuery.UPDATE_DEPARTMENT)) {
            statement.setString(1,department.getName());
            statement.setInt(2,department.getId());

            return statement.executeUpdate()>0;
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
