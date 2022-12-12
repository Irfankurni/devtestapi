package com.irfank.devtestapi.service;


import com.irfank.devtestapi.dao.ProfileDao;
import com.irfank.devtestapi.dto.InsertRes;
import com.irfank.devtestapi.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileDao profileDao;

    public List<Profile> findAll() throws Exception {
        return profileDao.findAllProfiles();
    }

    @Transactional(rollbackOn = Exception.class)
    public InsertRes insert(Profile profile) throws Exception {

        Profile inserted = profileDao.insertProfile(profile);

        InsertRes result = new InsertRes();
        result.setId(inserted.getId());
        result.setMessage("Success");
        return result;
    }
}
