package com.higherEducationGuid.restful.service.Impl;

import com.higherEducationGuid.restful.model.NewCourses;
import com.higherEducationGuid.restful.repository.NewCoursesRepository;
import com.higherEducationGuid.restful.service.NewCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
@Service
public class NewCoursesServiceImpl implements NewCoursesService {

    @Autowired
    NewCoursesRepository newCoursesRepository;

    @Override
    public NewCourses addNewCourses(NewCourses newCourses) {
        return newCoursesRepository.save(newCourses);
    }

    @Override
    public List<NewCourses> getNewCoursesList(){
        return newCoursesRepository.findAll();
    }

    @Override
    public NewCourses getNewCoursesById(int id) {
        return newCoursesRepository.findOne(id);
    }

    @Override
    public NewCourses editNewCourses(NewCourses newCourses) {
        return newCoursesRepository.save(newCourses);
    }

    @Override
    public void deleteNewCourses(int id) {
        newCoursesRepository.delete(id);
    }
}
