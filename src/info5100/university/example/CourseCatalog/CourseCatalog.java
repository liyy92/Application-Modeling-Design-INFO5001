/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    String lastupdated;
    ArrayList<Course> courselist; 
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }
    
    /*public boolean isThisCourseInStudentTranscript(StudentProfile s)  {
        for (int i = 0; i < courselist.size(); i++) {
            if (s.equals("respiratoryRate")) {
            return patienVitaltList.get(0).isInRange(this.respiratoryRate);
        }
    }
        ArrayList<Range> patienVitaltList = tableMap.get(this.ageGroup);
        if (input.equals("respiratoryRate")) {
            return patienVitaltList.get(0).isInRange(this.respiratoryRate);
        }
        if (input.equals("heartRate")) {
           return patienVitaltList.get(1).isInRange(this.heartRate);
        }
        if (input.equals("systolicBloodPressure")) {
           return patienVitaltList.get(2).isInRange(this.systolicBloodPressure);
        }
        if (input.equals("weightInKilos")) {
           return patienVitaltList.get(3).isInRange(this.weightInKilos);
        }
        if (input.equals("weightInPounds")) {
           return patienVitaltList.get(4).isInRange(this.weightInPounds);
        }
        return false;*/

}