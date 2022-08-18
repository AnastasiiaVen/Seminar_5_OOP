package com.day11;

import java.util.List;

public class TeacherRepository implements Repository<Teacher> {
    @Override
    public void save(Teacher teacher) {
        School.getTeacherList().add(teacher);
    }

    @Override
    public void delete(Teacher teacher) {

    }

    @Override
    public List<Teacher> findAll() {
        return School.getTeacherList();
    }
}
