package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee signUp(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword){
        boolean flag = false;
        if(employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword).size()>=1){
            flag= true;
        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public List<Employee> getDataByFirstName(String empFirstName){
        return employeeRepoImpl.findByEmpFirstName(empFirstName);
    }

    public Employee getDataByContactNumber(String empContactNumber){
        return employeeRepoImpl.findByEmpContactNumber(empContactNumber);
    }

    public Employee getDataByEmailId(String empEmailId){
        return employeeRepoImpl.findByEmpEmailId(empEmailId);
    }

    public List<Employee> getDataByEmpFirstNameAndLastName(String empFirstName, String empLastName){
        return employeeRepoImpl.findByEmpFirstNameAndEmpLastName(empFirstName, empLastName);
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public void deleteDataById(int empId){
        employeeRepoImpl.deleteById(empId);
    }
}
