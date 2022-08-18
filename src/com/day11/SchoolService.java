package com.day11;

public class SchoolService {

    Repository<Pupil> pupilRepository;
    Repository<>

    public SchoolService(Repository<Pupil> pupilRepository) {
        this.pupilRepository = pupilRepository;
    }

    void addPupil(Pupil pupil){
        pupilRepository.save(pupil);
    }

}
