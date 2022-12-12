package com.irfank.devtestapi.dao;

import com.irfank.devtestapi.entitymanager.BaseEntityManager;
import com.irfank.devtestapi.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDao extends BaseEntityManager {

    public List<Profile> findAllProfiles() throws Exception {
        String sql = "SELECT p FROM Profile p";
        List<Profile> profiles = em.createQuery(sql, Profile.class).getResultList();
        return profiles;
    }

    public Profile insertProfile(Profile profiles) throws Exception {
        em.persist(profiles);
        return profiles;
    }

}
