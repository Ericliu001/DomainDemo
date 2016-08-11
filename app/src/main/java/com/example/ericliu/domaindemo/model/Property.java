package com.example.ericliu.domaindemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ericliu on 10/08/2016.
 */

public class Property {

    @SerializedName("AgencyLogoUrl")
    private String agencyLogoUrl;


    @SerializedName("Bathrooms")
    private int bathrooms;

    @SerializedName("Bedrooms")
    private int bedrooms;

    @SerializedName("Carspaces")
    private int carspaces;


    @SerializedName("DisplayPrice")
    private String displayPrice;


    @SerializedName("DisplayableAddress")
    private String displayableAddress;


    @SerializedName("TruncatedDescription")
    private String truncatedDescription;


    @SerializedName("RetinaDisplayThumbUrl")
    private String retinaDisplayThumbUrl;


    @SerializedName("SecondRetinaDisplayThumbUrl")
    private String secondRetinaDisplayThumbUrl;


    @SerializedName("IsElite")
    private int isElite;
}
