package com.afifi.neveen.taskmanager2017.data;

/**
 * Created by user on 12/07/2017.
 */

public class MyTasks
{
    private String tKey;
    private String text;//tittle
    private  boolean isCompleted;
    private long createAt;
    private  double loc_lat,loc_lng;
    private String address;
    private String gKey,uKey;//the group and user that is belong

    public MyTasks()
    {

    }

    public String gettKey() {
        return tKey;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public long getCreateAt() {
        return createAt;
    }

    public double getLoc_lat() {
        return loc_lat;
    }

    public double getLoc_lng() {
        return loc_lng;
    }

    public String getAddress() {
        return address;
    }

    public String getgKey() {
        return gKey;
    }

    public String getuKey() {
        return uKey;
    }

    public void settKey(String tKey) {
        this.tKey = tKey;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public void setLoc_lat(double loc_lat) {
        this.loc_lat = loc_lat;
    }

    public void setLoc_lng(double loc_lng) {
        this.loc_lng = loc_lng;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public void setuKey(String uKey) {
        this.uKey = uKey;
    }


    @Override
    public String toString() {
        return "MyTasks{" +
                "tKey='" + tKey + '\'' +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createAt=" + createAt +
                ", loc_lat=" + loc_lat +
                ", loc_lng=" + loc_lng +
                ", adress='" + address + '\'' +
                ", gKey='" + gKey + '\'' +
                ", uKey='" + uKey + '\'' +
                '}';
    }
}
