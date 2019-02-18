package com.usco.project.service;

import com.usco.project.entity.SiteTrasing;
import com.usco.project.repository.SiteTrasingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("site_trasing_service")
public class SiteTrasingService {

    @Autowired
    @Qualifier("site_trasing_repository")
    private SiteTrasingRepository siteTrasingRepository;

    public Boolean addSiteTrasing(SiteTrasing siteTrasing) {

        SiteTrasing newSiteTrasing = siteTrasingRepository.save(siteTrasing);
        if (newSiteTrasing != null) {
            return true;
        } else {
            return false;
        }
    }
}