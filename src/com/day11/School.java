package com.day11;

import java.util.ArrayList;

public class School {
    private School() {
    }

    private static final ArrayList<Pupil> pupilList = new ArrayList<>();
    private static final ArrayList<Teacher> teacherList = new ArrayList<>();

    public static ArrayList<Pupil> getPupilList(){
        return pupilList;
    }

    public static ArrayList<Teacher> getTeacherList(){
        return teacherList;
    };

}
