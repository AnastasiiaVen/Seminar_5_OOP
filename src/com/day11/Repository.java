package com.day11;

import java.util.ArrayList;
import java.util.List;

public interface Repository<T> {
    void save(T t);
    void delete(T t);
    List<T> findAll();
}
