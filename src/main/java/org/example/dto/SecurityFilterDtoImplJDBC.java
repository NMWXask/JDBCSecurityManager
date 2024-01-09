package org.example.dto;

import org.example.entity.Security;
import org.example.exception.DtoException;
import org.example.query.SQLQuery;
import org.example.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SecurityFilterDtoImplJDBC implements Dto{
    @Override
    public List<Security> getBirthByMonth(int month) {
        List<Security> securityList = new ArrayList<>();

        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.GET_BIRTH_BY_MONTH);
        ) {
            statement.setInt(1, month);
            var result = statement.executeQuery();

            while (result.next()) {
                Security security = new Security();
                security.setFio(result.getString("fio"));
                security.setBirthDate(result.getDate("birth_date").toLocalDate());
                securityList.add(security);
            }
        } catch (SQLException e) {
            throw new DtoException(e);
        }

        return securityList;
    }

    @Override
    public Security findById(int id) {
        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SQLQuery.FIND_BY_ID)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();// селектом вернет нам результат
            Security security = null;
            if (result.next()) {
                security = buildSecurity(result);
            }

            return security;
        } catch (SQLException e) {
            throw new DtoException(e);
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
}
