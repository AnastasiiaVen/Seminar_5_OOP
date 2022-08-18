package com.day11;

public class Program {
    public static void main(String[] args) {

        SchoolService schoolService = new SchoolService(new PupilRepository());

        Pupil pupil = new Pupil("Ivan", "Ivanov", 15);
        schoolService.addPupil(pupil);
    }
}
