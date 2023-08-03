package com.unit5.educationservice.implementations;

import java.util.ArrayList;
import java.util.List;

import com.unit5.educationservice.Class;
import com.unit5.educationservice.ClassDataObject;
import com.unit5.educationservice.InstructorDataObject;
import com.unit5.educationservice.Student;
import com.unit5.educationservice.StudentDataObject;

public class EducationObjectImpl {

    private ClassDataObject classDataObject;
    private InstructorDataObject instructorDataObject;
    private StudentDataObject studentDataObject;

    public List<String> getAllStudentsBySubject(String subject) {
        List<Student> students = studentDataObject.getAllStudents();

        List<String> inClass = new ArrayList<String>();

        for (Student student : students) {
            if (subject.equals("math")
                    && (student.getSubject().equals("Calculus") || student.getSubject().equals("Algebra"))) {
                inClass.add(student.getName());
            }
        }

        return inClass;
    }

    public void markCurrentClassesInactive() {
        List<Class> classes = classDataObject.getAllClasses();

        for (Class c : classes) {
            if (c.getSubject().equals("Geometry"))
                classDataObject.markInactive(c);
        }

    }

    public List<String> getClassesByInstructor(String instructor_id){
        return instructorDataObject.getClassesByInstructor(instructor_id);
    }

    public List<String> getStudentsInClass(String class_id){
        return classDataObject.getStudentsInClass(class_id);
    }

}
