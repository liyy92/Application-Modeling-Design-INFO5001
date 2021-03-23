/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseCatalog.RequirementCourse;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.Seat;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create IS department and understand this department there would be a "Fall 2020 "semester.
        
        Department department = new Department("Information Systems");
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        // Add some courses at IS on Fall2020 semester.
        Course course = coursecatalog.newCourse("application engineering", "info 5100", 4);
        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer!=null)
        courseoffer.generatSeats(10);
        
        Course course2 = coursecatalog.newCourse("business analysis", "info 6215", 4);
        CourseOffer courseoffer2 = courseschedule.newCourseOffer("info 6215");
        if (courseoffer2!=null)
        courseoffer2.generatSeats(10);
        
        Course course3 = coursecatalog.newCourse("application modeling and desin", "info 5001", 4);
        CourseOffer courseoffer3 = courseschedule.newCourseOffer("info 5001");
        if (courseoffer3!=null)
        courseoffer3.generatSeats(10);
        
        // Create a person diretory and a student diretory, add some persons in student diretory, set a semester in student's courseload
        PersonDirectory pd = department.getPersonDirectory();
        Person person1 = pd.newPerson("01111");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student1 = sd.newStudentProfile(person1);
        CourseLoad courseload = student1.newCourseLoad("Fall2020"); 
        
        Person person2 = pd.newPerson("02222");
        StudentProfile student2 = sd.newStudentProfile(person2);
        CourseLoad courseload2 = student2.newCourseLoad("Fall2020");
        
        Person person3 = pd.newPerson("03333");
        StudentProfile student3 = sd.newStudentProfile(person3);
        CourseLoad courseload3 = student3.newCourseLoad("Fall2020");
        
        
        // Register student in different class and set grade to this class.
        // Student's courses
        SeatAssignment seatAssignmentStudent1a = courseload.newSeatAssignment(courseoffer); 
        seatAssignmentStudent1a.setGrade(4);
        
        SeatAssignment seatAssignmentStudent1b = courseload.newSeatAssignment(courseoffer2); 
        seatAssignmentStudent1b.setGrade(3.7f);
        
        SeatAssignment seatAssignmentStudent1c = courseload.newSeatAssignment(courseoffer3); 
        seatAssignmentStudent1c.setGrade(3.7f);
        
        // Student2's courses
        SeatAssignment seatAssignmentStudent2a = courseload2.newSeatAssignment(courseoffer); 
        seatAssignmentStudent2a.setGrade(3.6f);
        
        SeatAssignment seatAssignmentStudent2b = courseload2.newSeatAssignment(courseoffer2); 
        seatAssignmentStudent2b.setGrade(3.8f);
        
        SeatAssignment seatAssignmentStudent2c = courseload2.newSeatAssignment(courseoffer3); 
        seatAssignmentStudent2c.setGrade(3.0f);
        
        // Student3's courses
        SeatAssignment seatAssignmentStudent3a = courseload3.newSeatAssignment(courseoffer); 
        seatAssignmentStudent3a.setGrade(3.7f);
        
        SeatAssignment seatAssignmentStudent3b = courseload3.newSeatAssignment(courseoffer2); 
        seatAssignmentStudent3b.setGrade(3.9f);
        
        SeatAssignment seatAssignmentStudent3c = courseload3.newSeatAssignment(courseoffer3); 
        seatAssignmentStudent3c.setGrade(2.5f);
        
        // 
        Transcript studentTrascript1 = student1.getTranscript();
        Transcript studentTrascript2 = student2.getTranscript();
        Transcript studentTrascript3 = student3.getTranscript();
        
        // Create a ArrayList to store those three students.
        ArrayList<StudentProfile> studentList = new ArrayList<StudentProfile>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        
        // Part 1 
        System.out.println("-----------Part 1: GPA Calculations------------ " );
        for (int i = 0; i < studentList.size(); i++) {
            
            System.out.println("----------------------------------------------------------");
            System.out.println("Student id: " + studentList.get(i).getStudentId());
            System.out.println("GPA: " + studentList.get(i).getTranscript().getGPA());
        }
        System.out.println();
        System.out.println();
        
        
        // Part 2
        System.out.println("-----------Part 2: Total revenue at college and univeristy levels------------ " );
        System.out.println("----------------------------------------------------------");
        // Create "College Of Engineering" College, and add "IS" in it.
        College college1 = new College("College Of Engineering");
        college1.addDepartment(department);
        
        //  Creat a new department "data science" , add into "College Of Engineering" College.
        Department department2 = new Department("Date Science");
        CourseSchedule courseschedule2 = department2.newCourseSchedule("Fall2020");
        CourseCatalog coursecatalog2 = department2.getCourseCatalog();
        college1.addDepartment(department2);
        
        // Add some courses at "data science" department on Fall2020 semester.
        Course course2a = coursecatalog2.newCourse("Algorithms", "cs 5800", 6);
        CourseOffer courseoffer2a = courseschedule2.newCourseOffer("cs 5800");
        if (courseoffer2a!=null)
        courseoffer2a.generatSeats(10);
        
        Course course2b = coursecatalog2.newCourse("Database Management Systems", "cs 5200", 6);
        CourseOffer courseoffer2b = courseschedule2.newCourseOffer("cs 5200");
        if (courseoffer2b!=null)
        courseoffer2b.generatSeats(10);
        
        
        // Create a person diretory and a student diretory, add some persons in student diretory, set a semester in student's courseload in Date science department
        PersonDirectory pdInDs = department2.getPersonDirectory();
        Person personInDs1 = pdInDs.newPerson("04444");
        StudentDirectory sdINDs1 = department2.getStudentDirectory();
        StudentProfile studenInDs1 = sdINDs1.newStudentProfile(personInDs1);
        CourseLoad courseloadInDs1 = studenInDs1.newCourseLoad("Fall2020"); 
        
        Person personInDs2 = pdInDs.newPerson("05555");
        StudentProfile studentInDs2 = sdINDs1.newStudentProfile(personInDs2);
        CourseLoad courseloadInDs2 = studentInDs2.newCourseLoad("Fall2020");
        
        // students in date science department register class
        SeatAssignment seatAssignmentDsStudent1a = courseloadInDs1.newSeatAssignment(courseoffer2a); 
        SeatAssignment seatAssignmentDsStudent1b = courseloadInDs1.newSeatAssignment(courseoffer2b); 

        SeatAssignment seatAssignmentDsStudent2a = courseloadInDs2.newSeatAssignment(courseoffer2a); 
        SeatAssignment seatAssignmentDsStudent2b = courseloadInDs2.newSeatAssignment(courseoffer2b);
        
        
        // Create "Khoury College of Computer Sciences" College, and add "IS" in it.
        College college2 = new College("Khoury College of Computer Sciences");
        
        //  Creat a new department "Cybersecurity" , add into "Khoury College of Computer Sciences" College.
        Department departmentInCs1 = new Department("Cybersecurity");
        CourseSchedule coursescheduleInCs1 = departmentInCs1.newCourseSchedule("Fall2020");
        CourseCatalog coursecatalogInCs1 = departmentInCs1.getCourseCatalog();
        college2.addDepartment(departmentInCs1);
        
        //  Creat a new department "Robotics" , add into "Khoury College of Computer Sciences" College.
        Department departmentInCs2 = new Department("Robotics");
        CourseSchedule coursescheduleInCs2 = departmentInCs2.newCourseSchedule("Fall2020");
        CourseCatalog coursecatalogInCs2 = departmentInCs2.getCourseCatalog();
        college2.addDepartment(departmentInCs2);
        
        // Add some courses at "Cybersecurity" department on Fall2020 semester.
        Course courseInCs1a = coursecatalogInCs1.newCourse("Discrete Structures", "cs 1200", 7);
        CourseOffer courseofferInCs1a = coursescheduleInCs1.newCourseOffer("cs 1200");
        if (courseofferInCs1a!=null)
        courseofferInCs1a.generatSeats(10);
        
        // Add some courses at "Robotics" department on Fall2020 semester.
        Course courseInCs2a = coursecatalogInCs2.newCourse("Computer Systems", "cs 4300", 9);
        CourseOffer courseofferInCs2a = coursescheduleInCs2.newCourseOffer("cs 4300");
        if (courseofferInCs2a!=null)
        courseofferInCs2a.generatSeats(10);
        
        
        // Create a person diretory and a student diretory, add some persons in student diretory, set a semester in student's courseload in Cybersecurity department
        PersonDirectory pdInKCCS = departmentInCs1.getPersonDirectory();
        Person personInCybersecurity = pdInKCCS.newPerson("06666");
        StudentDirectory sdINKCCS = departmentInCs1.getStudentDirectory();
        StudentProfile studenInCybersecurity = sdINKCCS.newStudentProfile(personInCybersecurity);
        CourseLoad courseloadInCybersecurity = studenInCybersecurity.newCourseLoad("Fall2020"); 
        
        // Create a person diretory and a student diretory, add some persons in student diretory, set a semester in student's courseload in Robotics department
        Person personInRobotics = pdInKCCS.newPerson("07777");
        StudentProfile studentInRobotics = sdINKCCS.newStudentProfile(personInRobotics);
        CourseLoad courseloadInRobotics = studentInRobotics.newCourseLoad("Fall2020");
        
        // students in Cybersecurity  department register class
        SeatAssignment seatAssignmentCybersecurity = courseloadInCybersecurity.newSeatAssignment(courseofferInCs1a); 
        
        // students in Robotics  department register class
        SeatAssignment seatAssignmentInRobotics = courseloadInDs2.newSeatAssignment(courseofferInCs2a); 
        
        System.out.println("College name: " + college1.getName());
        int totalRevenueOfCollegeBysemeter = college1.calculateCollegeRevenues("Fall2020");
        System.out.println("Total Revenue in Fall 2020: " + totalRevenueOfCollegeBysemeter);
        for (Department d : college1.getDepartmentList().values()) {
            System.out.println( d.getName() + ": " + d.calculateRevenuesBySemester("Fall2020"));
        }
        System.out.println("----------------------------------------------------------");
        
                System.out.println("College name: " + college2.getName());
        int totalRevenueOfCollegeBysemeter2 = college2.calculateCollegeRevenues("Fall2020");
        System.out.println("Total Revenue in Fall 2020: " + totalRevenueOfCollegeBysemeter2);
        for (Department d : college2.getDepartmentList().values()) {
            System.out.println( d.getName() + ": " + d.calculateRevenuesBySemester("Fall2020"));
        //int total = department.calculateRevenuesBySemester("Fall2020");
        //System.out.println("Total: " + total);
        }
        System.out.println();
        System.out.println();
        
        // Part 3
        System.out.println("-----------Part 3: List all the teachers and the courses they taught for a given semester.------------ " );
        System.out.println("----------------------------------------------------------");
        
        // Create Faculty diretory and add some teacher in Information systems department.
        Person personTeacher1 = pd.newPerson("81234");
        FacultyDirectory fd = new FacultyDirectory(department);
        FacultyProfile teacher1 = fd.newFacultyProfile(personTeacher1);
        
        Person personTeacher2 = pd.newPerson("82531");
        FacultyProfile teacher2 = fd.newFacultyProfile(personTeacher2);
        
        // Assign those two teachers in info 5100 and info 6215
        FacultyAssignment FacultyAssignment1 = teacher1.AssignAsTeacher(courseoffer);
        FacultyAssignment FacultyAssignment2 = teacher2.AssignAsTeacher(courseoffer2);
        FacultyAssignment FacultyAssignment3 = teacher2.AssignAsTeacher(courseoffer3);
        
        // Let different students set raing for each course they have taken.
        // student1 in IS set rating:
        seatAssignmentStudent1a.setRating(4.3);
        seatAssignmentStudent1b.setRating(4.1);
        seatAssignmentStudent1c.setRating(4.8);
        
        // student2 in IS set rating 
        seatAssignmentStudent2a.setRating(4.2);
        seatAssignmentStudent2b.setRating(5);
        seatAssignmentStudent2c.setRating(5);
        
        // student3 in IS set rating
        seatAssignmentStudent3a.setRating(3.5);
        seatAssignmentStudent3b.setRating(5);
        seatAssignmentStudent3c.setRating(4.1);
        
        Seat seat1a = seatAssignmentStudent1a.getSeat();
        Seat seat1b = seatAssignmentStudent1b.getSeat();
        Seat seat1c = seatAssignmentStudent1c.getSeat();
        
        // Get raing for each courseoffer.
        
        ArrayList<CourseOffer> courseOfferList = new ArrayList<CourseOffer>();
        courseOfferList.add(courseoffer);
        courseOfferList.add(courseoffer2);
        courseOfferList.add(courseoffer3);
        courseOfferList.sort((a, b) -> (int)Math.signum(b.getCourseRating() - a.getCourseRating()));
        System.out.println("Department:" + department.getName());
        for (CourseOffer i: courseOfferList) {
                    System.out.println(i.getCourse().getName() +" " + i.getFacultyProfile().getPerson().getPersonId() +" " + i.getCourseRating());

        }
        
        
        
        System.out.println();
        System.out.println();
        
        // Part 4
        System.out.println("-----------Part 4: if a student fulfilled their course graduation requirements------------ " );
        System.out.println("----------------------------------------------------------");
        RequirementCourse reqList = new RequirementCourse();
        reqList.addReuirement(courseoffer);
        reqList.addReuirement(courseoffer2);
        reqList.addReuirement(courseoffer3);
        
        if (reqList.isSatisfied(student1, "Fall2020") == true){
                     System.out.println("This student " + student1.getPerson().getPersonId() + " has fullfuield course graduation requeirement");
                 } else {
                        System.out.println("This student " + student1.getPerson().getPersonId() + " hasn't fullfuield course graduation requeirement");;
                    }
            }  
    }
    
        

        
  
