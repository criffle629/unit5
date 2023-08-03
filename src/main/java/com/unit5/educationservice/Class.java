package com.unit5.educationservice;

public class Class {
    private String subject;
    private String semester;

    private boolean inActive;


    public Class(String subject, String semester) {
        this.subject = subject;
        this.semester = semester;

        this.inActive = true;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setActive(boolean val){
        inActive = val;
    }
    public void markInactive() {
        this.inActive = false;
    }

}
