package com.higherEducationGuid.restful.controller;

import com.higherEducationGuid.restful.model.NewCourses;
import com.higherEducationGuid.restful.service.NewCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
@RestController
@RequestMapping("/course")
public class NewCoursesController {
    @Autowired
    NewCoursesService newCoursesService;


    //get course list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<NewCourses>> getAllCourses() {
        List<NewCourses> newCoursesList = newCoursesService.getNewCoursesList();
        if (newCoursesList.isEmpty()) {
            //logger.debug("Users does not exists");
            return new ResponseEntity<List<NewCourses>>(HttpStatus.NO_CONTENT);
        }
        //logger.debug("Found " + usersList.size() + " Users");
        //logger.debug(Arrays.toString(usersList.toArray()));
        return new ResponseEntity<List<NewCourses>>(newCoursesList, HttpStatus.OK);
    }


    //add driver
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<NewCourses> addDriver(@RequestBody NewCourses newCourses){
        NewCourses persistNewCourses = newCoursesService.addNewCourses(newCourses);
        //logger.debug("Added:: " + persistUser);
        return new ResponseEntity<NewCourses>(persistNewCourses,HttpStatus.CREATED);
    }


}
