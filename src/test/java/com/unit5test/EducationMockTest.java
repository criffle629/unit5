package com.unit5test;


import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;


import com.unit5.educationservice.ClassDataObject;
import com.unit5.educationservice.InstructorDataObject;
import com.unit5.educationservice.Student;
import com.unit5.educationservice.StudentDataObject;
import com.unit5.educationservice.Class;
import com.unit5.educationservice.Instructor;

import com.unit5.educationservice.implementations.EducationObjectImpl;

public class EducationMockTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private EducationObjectImpl educationObjectImpl;

    @Test
public void testStudentsByClass() {

    Student studentJM = new Student("Joy Ma", "Spanish");
    Student studentJH = new Student("Julio Hernandez", "Algebra");
    Student studentJJ = new Student("Jenny Jones", "Calculus");

    List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);
 
    given(studentDataObject.getAllStudents()).willReturn(allStudents);

    List<String> mathStudents = educationObjectImpl.getAllStudentsBySubject("math");

    assertThat(mathStudents.size(), is(2));
    assertThat(mathStudents, hasItems(studentJJ.getName(), studentJH.getName()));
}

    @Test
    public void testMarkInactive() {

        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");

        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        educationObjectImpl.markCurrentClassesInactive();

        verify(classDataObject).markInactive(geometry);
        verify(classDataObject, Mockito.never()).markInactive(envSci);
        verify(classDataObject, Mockito.never()).markInactive(compLit);
        verify(classDataObject, Mockito.times(1)).markInactive(geometry);
    }
 
    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testMarkInactive_argumentCaptor() {

        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");

        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        educationObjectImpl.markCurrentClassesInactive();

        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
    }
    
    @Test
    public void testGetClassesByInstructorr(){
        instructorDataObject = new InstructorDataObject();
        Instructor instructor1 = new Instructor("Bob", "Calculus");
        Instructor instructor2 = new Instructor("Bob", "History");
        instructorDataObject.getInstructors().add(instructor1);
        instructorDataObject.getInstructors().add(instructor2);

        List<String> result = instructorDataObject.getClassesByInstructor("instructor1");

        List<String> classesExpected = Arrays.asList("Calculus", "History");
    
        assertTrue(result.equals(classesExpected));
    }

        
    @Test
    public void testGetStudentsInClass(){
        
        Class class1 = new Class("Math", "Fall");
        Class class2 = new Class("Science", "Fall");
        Class class3 = new Class("English", "Fall");

        List<Class> classes = new ArrayList<>();

        classes.add(class1);
        classes.add(class2);
        classes.add(class3);

        classDataObject = new ClassDataObject(classes);

        Student student1 = new Student("Bob", "Math");
        Student student2 = new Student("Mary", "English");
        Student student3 = new Student("Greg", "Math");
        Student student4 = new Student("Joe", "Science");

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        studentDataObject = new StudentDataObject(students);

        classDataObject.setStudentDataObject(studentDataObject);


        List<String> result = classDataObject.getStudentsInClass("Math");


        List<String> studentsExpected = Arrays.asList("Bob", "Greg");

        assertTrue(result.equals(studentsExpected));
    }

}
