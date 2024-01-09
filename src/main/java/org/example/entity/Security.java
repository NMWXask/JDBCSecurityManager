package org.example.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Security {
    private int id;
    private String fio;
    private String gender;
    private LocalDate birthDate;
    private int department;
    private LocalDate dateOfHealthPermit;
    private LocalDate dateOfKnowledgePermit;
    private LocalDate dateOfWeaponPermit;

    public Security(int id, String fio, String gender, LocalDate birthDate,
                    int department, LocalDate dateOfHealthPermit,
                    LocalDate dateOfKnowledgePermit, LocalDate dateOfWeaponPermit) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.dateOfHealthPermit = dateOfHealthPermit;
        this.dateOfKnowledgePermit = dateOfKnowledgePermit;
        this.dateOfWeaponPermit = dateOfWeaponPermit;
    }

    public Security(int id, String fio, LocalDate birthDate, int department) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
        this.department = department;
    }

    public Security(String fio, int department, LocalDate dateOfHealthPermit, LocalDate dateOfKnowledgePermit, LocalDate dateOfWeaponPermit) {
        this.fio = fio;
        this.department = department;
        this.dateOfHealthPermit = dateOfHealthPermit;
        this.dateOfKnowledgePermit = dateOfKnowledgePermit;
        this.dateOfWeaponPermit = dateOfWeaponPermit;
    }

    public Security(String fio, LocalDate birthDate) {
        this.fio = fio;
        this.birthDate = birthDate;
    }

    public Security() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public LocalDate getDateOfHealthPermit() {
        return dateOfHealthPermit;
    }

    public void setDateOfHealthPermit(LocalDate dateOfHealthPermit) {
        this.dateOfHealthPermit = dateOfHealthPermit;
    }

    public LocalDate getDateOfKnowledgePermit() {
        return dateOfKnowledgePermit;
    }

    public void setDateOfKnowledgePermit(LocalDate dateOfKnowledgePermit) {
        this.dateOfKnowledgePermit = dateOfKnowledgePermit;
    }

    public LocalDate getDateOfWeaponPermit() {
        return dateOfWeaponPermit;
    }

    public void setDateOfWeaponPermit(LocalDate dateOfWeaponPermit) {
        this.dateOfWeaponPermit = dateOfWeaponPermit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return id == security.id && gender == security.gender && department == security.department
               && Objects.equals(fio, security.fio) && Objects.equals(birthDate, security.birthDate)
               && Objects.equals(dateOfHealthPermit, security.dateOfHealthPermit) &&
               Objects.equals(dateOfKnowledgePermit, security.dateOfKnowledgePermit) &&
               Objects.equals(dateOfWeaponPermit, security.dateOfWeaponPermit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, gender, birthDate, department,
                dateOfHealthPermit, dateOfKnowledgePermit, dateOfWeaponPermit);
    }

    @Override
    public String toString() {
        return "Сотрудник :" +
               "id :" + id +
               ", ФИО :'" + fio + '\'' +
               ", Пол :" + gender +
               ", дата рождения :" + birthDate +
               ", номер отдела :" + department +
               ", дата прохождения мед.комиссии :" + dateOfHealthPermit +
               ", дата тестирования знаний :" + dateOfKnowledgePermit +
               ", дата прохождения комиссии на оружие :" + dateOfWeaponPermit +
               '\n';
    }

}
