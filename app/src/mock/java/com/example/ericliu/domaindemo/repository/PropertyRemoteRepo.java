package com.example.ericliu.domaindemo.repository;

import com.example.ericliu.domaindemo.model.Property;
import com.example.ericliu.domaindemo.repository.base.Repository;
import com.example.ericliu.domaindemo.repository.base.Specification;

import java.util.List;

/**
 * Created by ericliu on 10/08/2016.
 */

public class PropertyRemoteRepo implements Repository<Property> {
    @Override
    public Property get(Specification specification) throws Exception {
        return null;
    }

    @Override
    public void add(Property item) throws Exception {

    }

    @Override
    public void add(Iterable<Property> items) throws Exception {

    }

    @Override
    public void update(Property item) throws Exception {

    }

    @Override
    public void remove(Property item) throws Exception {

    }

    @Override
    public void remove(Specification specification) throws Exception {

    }

    @Override
    public List<Property> query(Specification specification) throws Exception {
        return null;
    }
}
