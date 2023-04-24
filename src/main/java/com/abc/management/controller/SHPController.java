package com.abc.management.controller;


import com.abc.management.exception.ResourceNotFoundException;
import com.abc.management.model.StudentHasProgramme;
import com.abc.management.model.programme;
import com.abc.management.repository.ProgrammeRepo;
import com.abc.management.repository.SHPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/register")
public class SHPController {

    @Autowired
    private SHPRepo shpRepo;


    //Get All Registration Details
    @GetMapping
    public List<StudentHasProgramme> getAllRegistration(){
        return shpRepo.findAll();
    }


    //Add new registration record
    @PostMapping
    public StudentHasProgramme addProgramme(@RequestBody StudentHasProgramme studentHasProgramme){
        return shpRepo.save(studentHasProgramme);
    }


    //Get Registration Details by id
    @GetMapping("{SPid}")
    public ResponseEntity<StudentHasProgramme> getRegisterDetailById(@PathVariable long SPid)
    {
        StudentHasProgramme studentHasProgramme = shpRepo.findById(SPid)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not Exist" + SPid));
        return ResponseEntity.ok(studentHasProgramme);
    }


    //Update Record
    @PutMapping("{SPid}")
    public ResponseEntity<StudentHasProgramme> updateRegistration(@PathVariable long SPid,@RequestBody StudentHasProgramme studentHasProgrammeDetails){
        StudentHasProgramme UpdatestudentHasProgramme = shpRepo.findById(SPid)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not Exist" + SPid));


      UpdatestudentHasProgramme.setRegisterDate(studentHasProgrammeDetails.getRegisterDate());
      UpdatestudentHasProgramme.setPid(studentHasProgrammeDetails.getPid());
      UpdatestudentHasProgramme.setSid(studentHasProgrammeDetails.getSid());
        shpRepo.save(UpdatestudentHasProgramme);
        return ResponseEntity.ok(UpdatestudentHasProgramme);

    }


    //Delete Record
    @DeleteMapping("{SPid}")
    public ResponseEntity<HttpStatus> deleteProgramme(@PathVariable long SPid){
        StudentHasProgramme studentHasProgramme = shpRepo.findById(SPid)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not Exist" + SPid));

        shpRepo.delete(studentHasProgramme);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
