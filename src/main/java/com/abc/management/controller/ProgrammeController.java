package com.abc.management.controller;


import com.abc.management.exception.ResourceNotFoundException;
import com.abc.management.model.programme;
import com.abc.management.model.student;
import com.abc.management.repository.ProgrammeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programme")
public class ProgrammeController {


    @Autowired
    private ProgrammeRepo programmeRepo;


    //Get All Programme records
    @GetMapping
    public List<programme> getAllProgrammes(){
        return programmeRepo.findAll();
    }


    // Add new Programme Record
    @PostMapping
    public programme addProgramme(@RequestBody programme Programme){
        return programmeRepo.save(Programme);
    }


//Get Programme record by programme ID
    @GetMapping("{pid}")
    public ResponseEntity<programme> getProgrammeById(@PathVariable long pid)
    {
        programme Programme = programmeRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Programme not Exist" + pid));
        return ResponseEntity.ok(Programme);
    }

//Update Record
    @PutMapping("{pid}")
    public ResponseEntity<programme> updateStudents(@PathVariable long pid,@RequestBody programme ProgrammeDetails){
        programme UpdateProgramme= programmeRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Programme not Exist" + pid));

        UpdateProgramme.setName(ProgrammeDetails.getName());
        UpdateProgramme.setDuration(ProgrammeDetails.getDuration());
        UpdateProgramme.setCost(ProgrammeDetails.getCost());
        programmeRepo.save(UpdateProgramme);
        return ResponseEntity.ok(UpdateProgramme);

    }


    //Delete Programme Record
    @DeleteMapping("{pid}")
    public ResponseEntity<HttpStatus> deleteProgramme(@PathVariable long pid){
        programme Programme= programmeRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Programme not Exist" + pid));

        programmeRepo.delete(Programme);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
