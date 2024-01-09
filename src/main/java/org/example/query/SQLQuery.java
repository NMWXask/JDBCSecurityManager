package org.example.query;

public final class SQLQuery {

    public final static String FIND_ALL = """
            SELECT * FROM security.public.security;
            """;
    public final static String SAVE_SQL = """
            INSERT INTO security.public.security (fio, gender, birth_date,
             department_id, date_of_annual_med_commission_health
             , date_of_annual_knowledge_test_of_weapon, date_of_every_five_years_med_commission_for_weapon)
             VALUES (?,?,?,?,?,?,?)
             """;

    public final static String DELETE_SQL = """
            DELETE FROM security.public.security id
            WHERE id = ?
             """;

    public final static String FIND_BY_ID = """
            select * from security where id = ?
            """;

    public final static String UPDATE_SQL = """
            UPDATE  security.public.security 
            SET fio = ?,
             gender = ?, 
             birth_date = ? , 
             department_id = ?, 
             date_of_annual_med_commission_health = ?, 
             date_of_annual_knowledge_test_of_weapon = ?, 
             date_of_every_five_years_med_commission_for_weapon = ?
            WHERE id = ?
             """;

    public final static String GET_BIRTH_BY_MONTH = """
            SELECT fio,birth_date FROM security.public.security WHERE EXTRACT(MONTH FROM birth_date) = ?;
            """;

    public final static String GET_ALL_DEPARTMENTS = """
            SELECT * FROM public.department;\s
            """;

    public final static String SAVE_DEPARTMENT = """
            INSERT INTO public.department (name)
            VALUES (?);
            """;

    public final static String DELETE_DEPARTMENT = """
            DELETE FROM department 
            WHERE id = ?;
            """;

    public static final String UPDATE_DEPARTMENT = """
            UPDATE department
            SET name = ?
            WHERE id = ?
            """;
}
