package com.example.ericliu.domaindemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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


    public List<String> getImageUrls() {
        return imageUrls;
    }

    @SerializedName("ImageUrls")
    private List<String> imageUrls;

    public String getAgencyLogoUrl() {
        return agencyLogoUrl;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getCarspaces() {
        return carspaces;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public String getDisplayableAddress() {
        return displayableAddress;
    }

    public String getTruncatedDescription() {
        return truncatedDescription;
    }

    public String getRetinaDisplayThumbUrl() {
        return retinaDisplayThumbUrl;
    }

    public String getSecondRetinaDisplayThumbUrl() {
        return secondRetinaDisplayThumbUrl;
    }

    public int getIsElite() {
        return isElite;
    }
}
