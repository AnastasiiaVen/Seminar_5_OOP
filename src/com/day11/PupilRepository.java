package com.day11;

import java.util.List;

public class PupilRepository implements Repository<Pupil>{
    @Override
    public void save(Pupil pupil) {
        School.getPupilList().add(pupil);
    }

    @Override
    public void delete(Pupil pupil) {

    }

    @Override
    public List<Pupil> findAll() {
        return School.getPupilList();
    }
}
