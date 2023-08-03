package com.unit5.educationservice;

import java.util.ArrayList;
import java.util.List;

public class StudentDataObject {
    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentDataObject(List<Student> students) {
        this.students = students;
    }
    
}
