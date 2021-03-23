/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author reaso
 */
public class RequirementCourse {
    ArrayList<CourseOffer> reqList;
    public RequirementCourse() {
        reqList = new ArrayList<>();
    }
    public void addReuirement(CourseOffer c) {
        reqList.add(c);
    }
    public boolean isSatisfied(StudentProfile s, String semester) {
        HashSet<String> studentCourseName = new HashSet<String>();
        for (SeatAssignment sa : s.getTranscript().getCourseloadlist().get(semester).getSeatassignments()) {
            studentCourseName.add(sa.getSeat().getCourseOffer().getCourse().getName());
        }
        for(CourseOffer x: reqList) {
            if(! studentCourseName.contains(x.getCourse().getName())) {
                return false;
            }
        }
        return true;
    }
}
