package com.example.mock_1;

import com.example.mock_1.entity.Employee;
import com.example.mock_1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class Test
{
    @Autowired
    public static EmployeeRepository employeeRepository;

    public static void main(String[] args)
    {
//        Validation.checkPassword("vdd");
//        System.out.println(Validation.checkPhoneNumber("0123456789"));
//
//        System.out.println(Validation.checkEmail
//        ("vanhoang@gmail.com.vn"));
    }

}
