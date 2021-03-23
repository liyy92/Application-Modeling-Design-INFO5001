/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import java.util.HashMap;



/**
 *
 * @author reaso
 */
public class College {
    
    String name;
    HashMap<String, Department> departmentList;
    
    
    public College (String name) {
        this.name = name;
        departmentList = new HashMap<String, Department>();
    }
    
    public void addDepartment(Department department) {
        departmentList.put(department.getName(), department);
    }
    
    public int calculateCollegeRevenues(String semester) {
        int sum = 0;
        for (Department department : departmentList.values()) {
            sum = sum + department.calculateRevenuesBySemester(semester);
        }
        return sum;

    }

    public String getName() {
        return name;
    }


    public HashMap<String, Department> getDepartmentList() {
        return departmentList;
    }

}
