package org.example.dao;

import java.util.List;

public interface Dao<E,K> {
    List<E> getAll();//метод, который выводит всех сотрудников(отделы)
    E save(E e);//метод который добавляет сотрудника(отдел)
    boolean delete(int K);//метод который удаляет сотрудника(отдел)
    boolean update(E e);//метод который обновляет данные сотрудника(отдел)
}
