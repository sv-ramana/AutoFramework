package POJOPractiseSerialise;

import java.util.List;

public class AddPlace {
    private location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String lauguage;

    public location getlocation() {
        return location;
    }
    public void setlocation(location location) {
        this.location = location;
    }
    public Integer getaccuracy() {
        return accuracy;
    }
    public void setaccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getWebsite() {
        return website;
    }
    public void setLauguage(String lauguage) {
        this.lauguage = lauguage;
    }
    public String getLauguage() {
        return lauguage;
    }
}
