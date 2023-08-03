package com.unit5.educationservice;

import java.util.ArrayList;
import java.util.List;

public class InstructorDataObject {
    private List<Instructor> instructors = new ArrayList<>();

    public void addInstructor(Instructor instructor){
        instructors.add(0, instructor);
    }
    
    public List<String> getClassesByInstructor(String instructor_id){
        List<String> classes = new ArrayList<>();

        for (Instructor instructor: getInstructors()){
            classes.add(instructor.getSubject());
        }

        return classes;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
