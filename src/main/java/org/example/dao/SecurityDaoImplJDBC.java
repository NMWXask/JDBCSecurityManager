package org.example.dao;

import org.example.entity.Security;
import org.example.exception.DaoException;
import org.example.query.SQLQuery;
import org.example.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public final class SecurityDaoImplJDBC implements Dao<Security, Integer> {
    @Override
    public List<Security> getAll() {
        List<Security> securityList = new ArrayList<>();
        Security security = null;


        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.FIND_ALL)) {

            var result = statement.executeQuery();

            while (result.next()) {
                securityList.add(
                        buildSecurity(result)
                );
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return securityList;
    }

    public Security save(Security security) {
        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            setSecurityFields(security, statement);

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();//это ResultSet, который выдает набор id которые были сгенерированы.
            if (keys.next()) {
                security.setId(keys.getInt("id"));
            }

            return security;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(int id) {
        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.DELETE_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;//если больше нуля строчек проапдейтили, то что - то удалили, вернет true
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean update(Security security) {
        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.UPDATE_SQL)) {
            setSecurityFields(security, statement);
            statement.setInt(8, security.getId());

            return statement.executeUpdate() > 0;//если больше нуля строчек проапдейтили, то что - то добавили, вернет true
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Security buildSecurity(ResultSet result) throws SQLException {
        return new Security(
                result.getInt("id"),
                result.getString("fio"),
                result.getString("gender"),
                result.getDate("birth_date").toLocalDate(),
                result.getInt("department_id"),
                result.getDate("date_of_annual_med_commission_health").toLocalDate(),
                result.getDate("date_of_annual_knowledge_test_of_weapon").toLocalDate(),
                result.getDate("date_of_every_five_years_med_commission_for_weapon").toLocalDate());
    }

    private void setSecurityFields(Security security, PreparedStatement statement) throws SQLException {
        statement.setString(1, security.getFio());
        statement.setString(2, security.getGender());
        statement.setDate(3, Date.valueOf(security.getBirthDate()));
        statement.setInt(4, security.getDepartment());
        statement.setDate(5, Date.valueOf(security.getDateOfHealthPermit()));
        statement.setDate(6, Date.valueOf(security.getDateOfKnowledgePermit()));
        statement.setDate(7, Date.valueOf(security.getDateOfWeaponPermit()));
    }


}
