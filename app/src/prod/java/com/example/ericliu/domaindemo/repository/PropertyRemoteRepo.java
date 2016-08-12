package com.example.ericliu.domaindemo.repository;

import com.example.ericliu.domaindemo.model.Property;
import com.example.ericliu.domaindemo.parsing.SearchResult;
import com.example.ericliu.domaindemo.repository.base.Repository;
import com.example.ericliu.domaindemo.repository.base.Specification;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        String url = "https://rest.domain.com.au/searchservice.svc/mapsearch?mode=buy&sub=Bondi&pcodes=2026&state=NSW";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        response = new OkHttpClient().newCall(request).execute();

        if (response.isSuccessful()) {

            Gson gson = new Gson();

            SearchResult searchResult = gson.fromJson(response.body().string(), SearchResult.class);
            if (searchResult == null || searchResult.listingResults == null || searchResult.listingResults.listings == null) {
                return null;
            }

            return searchResult.listingResults.listings;
        } else {
            // TODO: 15/05/2016  throw exception
        }
        return null;
    }
}
