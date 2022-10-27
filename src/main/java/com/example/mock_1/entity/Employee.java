package com.example.mock_1.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Not blank account")
    private String account;

    @NotBlank(message = "Not blank department")
    private String department;

    private String employeeAddress;

    private LocalDate employeeBirthdate;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
    private String employeeEmail;

    @NotBlank(message = "Not blank Name")
    private String employeeName;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Invalid phone number")
    private String employeePhone;

//    Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Invalid password")
    private String password;

    @Pattern(regexp = "^male$|^female$|^other$", message = "Sex must male or female or other")
    private String sex;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getAccount() {
        return account;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public LocalDate getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setEmployeeBirthdate(LocalDate employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
