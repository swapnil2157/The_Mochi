package com.The_Mochi.Swap;

public class UserModel {
    String DaysOpen, contactNo, facilities, name, latitude;


    public UserModel(String daysOpen, String contactNo, String facilities, String name) {
        DaysOpen = daysOpen;
        this.contactNo = contactNo;
        this.facilities = facilities;
        this.name = name;
        this.latitude = latitude;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public UserModel() {
    }

    public String getDaysOpen() {
        return DaysOpen;
    }

    public void setDaysOpen(String daysOpen) {
        DaysOpen = daysOpen;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
