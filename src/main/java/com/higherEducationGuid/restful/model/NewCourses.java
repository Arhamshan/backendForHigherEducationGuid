package com.higherEducationGuid.restful.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
@Entity
@Table(name = "newcourses")
public class NewCourses implements Serializable {

    private static final long serialVersionUID = -2518711478072920002L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "alstreem", length = 255)
    private String alstreem;
    @Column(name = "alresult", length = 255)
    private String alresult;
    @Column(name = "olresult", length = 255)
    private String olresult;
    @Column(name = "courseperiod", length = 255)
    private String courseperiod;


    public NewCourses(){}

    public NewCourses(int id){this.id = id;}

    public NewCourses(int id, String title, String alstreem, String alresult, String olresult, String courseperiod){
        this.id = id;
        this.title = title;
        this.alstreem = alstreem;
        this.alresult = alresult;
        this.olresult = olresult;
        this.courseperiod = courseperiod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlstreem() {
        return alstreem;
    }

    public void setAlstreem(String alstreem) {
        this.alstreem = alstreem;
    }

    public String getAlresult() {
        return alresult;
    }

    public void setAlresult(String alresult) {
        this.alresult = alresult;
    }

    public String getOlresult() {
        return olresult;
    }

    public void setOlresult(String olresult) {
        this.olresult = olresult;
    }

    public String getCourseperiod() {
        return courseperiod;
    }

    public void setCourseperiod(String courseperiod) {
        this.courseperiod = courseperiod;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (id == null || obj == null || getClass() != obj.getClass())
//            return false;
//        User toCompare = (User) obj;
//        return id.equals(toCompare.id);
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }

}
