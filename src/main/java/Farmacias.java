import com.squareup.moshi.Json;

import java.util.List;

public class Farmacias {
    @Json(name = "address")
    private String address;
    @Json(name = "extra")
    private Extra extra;
    @Json(name = "name")
    private String name;
    @Json(name = "geolocation")
    private List<Double> geolocation;

    public Farmacias(String address, Extra extra, String name, List<Double> geolocation) {
        this.address = address;
        this.extra = extra;
        this.name = name;
        this.geolocation = geolocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(List<Double> geolocation) {
        this.geolocation = geolocation;
    }
}
