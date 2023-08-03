package com.unit5.educationservice;

import java.util.ArrayList;
import java.util.List;

public class ClassDataObject {
    private List<Class> classes = new ArrayList<>();
    private StudentDataObject studentDataObject;
    
    public StudentDataObject getStudentDataObject() {
        return studentDataObject;
    }

    public void setStudentDataObject(StudentDataObject studentDataObject) {
        this.studentDataObject = studentDataObject;
    }

    public ClassDataObject(List<Class> classes) {
        this.classes = classes;
    }

    public List<Class> getAllClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void markInactive(Class cls) {
        cls.markInactive();
    }

    public List<String> getStudentsInClass(String class_id){
        List<String> output = new ArrayList<>();

        List<Student> students = studentDataObject.getAllStudents();
        for (Student student: students){
            if (student.getSubject().equals(class_id))
                output.add(student.getName());
        }

        return output;
    }
    
}
