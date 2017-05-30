package com.higherEducationGuid.restful.controller;

import com.higherEducationGuid.restful.model.NewCourses;
import com.higherEducationGuid.restful.service.NewCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
@RestController
@CrossOrigin(allowedHeaders="*",allowCredentials="true")
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


    //add course
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<NewCourses> addCourses(@RequestBody NewCourses newCourses){
        NewCourses persistNewCourses = newCoursesService.addNewCourses(newCourses);
        //logger.debug("Added:: " + persistUser);
        return new ResponseEntity<NewCourses>(persistNewCourses,HttpStatus.CREATED);
    }

    //edit courses
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<NewCourses> editCourses(@RequestBody NewCourses newCourses){
        NewCourses existingCourses = newCoursesService.getNewCoursesById(newCourses.getId());
        //logger.debug("Added:: " + persistUser);
        if (existingCourses == null) {
            return new ResponseEntity<NewCourses>(HttpStatus.NOT_FOUND);
        } else {
            NewCourses persistCourses = newCoursesService.editNewCourses(newCourses);
            return new ResponseEntity<NewCourses>(persistCourses,HttpStatus.OK);
        }
    }

    //delete vehicle
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCourses(@PathVariable("id") int id) {
        System.out.println("Data deleting.....");
        NewCourses existingNewCourses = newCoursesService.getNewCoursesById(id);
        if (existingNewCourses == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            newCoursesService.deleteNewCourses(id);
            return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
        }
    }

}
