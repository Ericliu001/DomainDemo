package com.example.ericliu.domaindemo.repository.base;

import java.util.Collection;

/**
 * Created by ericliu on 12/04/2016.
 */

public interface Repository<T> {
    T get(Specification specification) throws Exception;

    void add(T item) throws Exception;

    void add(Iterable<T> items) throws Exception;

    void update(T item) throws Exception;

    void remove(T item) throws Exception;

    void remove(Specification specification) throws Exception;

    Collection<T> query(Specification specification) throws Exception;
}