package com.higherEducationGuid.restful.service;

import com.higherEducationGuid.restful.model.NewCourses;

import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
public interface NewCoursesService {
    NewCourses addNewCourses(NewCourses newCourses);
    List<NewCourses> getNewCoursesList();

}
