package com.example.ericliu.domaindemo.parsing;

import com.example.ericliu.domaindemo.model.Property;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ericliu on 11/08/2016.
 */

public class ListingResults {

    @SerializedName("Listings")
    public List<Property> listings;
}
