package com.irfank.devtestapi.controller;

import com.irfank.devtestapi.dto.InsertRes;
import com.irfank.devtestapi.model.Profile;
import com.irfank.devtestapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<?> findAll() throws Exception {
        List<Profile> data = profileService.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Profile profile) throws Exception {
        InsertRes data = profileService.insert(profile);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
