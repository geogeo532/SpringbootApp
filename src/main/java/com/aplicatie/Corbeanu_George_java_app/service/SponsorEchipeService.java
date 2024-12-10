package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipeId;

import java.util.List;

public interface SponsorEchipeService {

    List<SponsorEchipe> get();

    SponsorEchipe get(SponsorEchipeId id);

    void save(SponsorEchipe sponsorEchipe);

    void update(SponsorEchipe sponsorEchipe);

    void delete(SponsorEchipeId id);
}
