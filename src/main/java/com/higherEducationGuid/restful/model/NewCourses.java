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
    @Column(name = "institue", length = 255)
    private String institue;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "level", length = 255)
    private String level;
    @Column(name = "alstreem", length = 255)
    private String alstreem;
    @Column(name = "alresult", length = 255)
    private String alresult;
    @Column(name = "olresult", length = 255)
    private String olresult;
    @Column(name = "courseperiod", length = 255)
    private String courseperiod;
    @Column(name = "coursedetails", length = 255)
    private String coursedetails;


    public NewCourses(){}

    public NewCourses(int id){this.id = id;}

    public NewCourses(int id, String institue, String title, String level, String alstreem, String alresult, String olresult, String courseperiod, String coursedetails){
        this.id = id;
        this.institue = institue;
        this.title = title;
        this.level=level;
        this.alstreem = alstreem;
        this.alresult = alresult;
        this.olresult = olresult;
        this.courseperiod = courseperiod;
        this.coursedetails=coursedetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitue() {
        return institue;
    }

    public void setInstitue(String institue) {
        this.institue = institue;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCoursedetails() {
        return coursedetails;
    }

    public void setCoursedetails(String coursedetails) {
        this.coursedetails = coursedetails;
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
