package com.higherEducationGuid.restful.service;

import com.higherEducationGuid.restful.model.NewCourses;

import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
public interface NewCoursesService {
    List<NewCourses> getNewCoursesList();
    NewCourses getNewCoursesById(int id);

    NewCourses addNewCourses(NewCourses newCourses);
    NewCourses editNewCourses(NewCourses newCourses);
    void deleteNewCourses(int id);

}
