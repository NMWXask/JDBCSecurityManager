package org.example.dto;

import org.example.entity.Security;

import java.util.HashMap;
import java.util.List;

public interface Dto {
    List<Security> getBirthByMonth(int month);//метод который выводит всех сотрудников, у кого др в заданном месяце
    Security findById(int id);//метод поиска сотрудника по id

}
