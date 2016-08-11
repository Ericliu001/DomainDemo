package com.example.ericliu.domaindemo.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 10/08/2016.
 */

public class PropertyRepoTest {

    PropertyRemoteRepo mRemoteRepo;

    @Before
    public void setUp() throws Exception {
        mRemoteRepo = new PropertyRemoteRepo();
    }

    @After
    public void tearDown() throws Exception {
        mRemoteRepo = null;

    }

    @Test
    public void testGet() throws Exception {
        mRemoteRepo.get(null);

    }
}
