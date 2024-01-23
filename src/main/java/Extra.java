import com.squareup.moshi.Json;

public class Extra {
    @Json(name = "postalAddress")
    private String postalAddress;
    @Json(name = "phoneNumber")
    private String phoneNumber;
    @Json(name = "city")
    private String city;
    @Json(name = "zone")
    private String zone;

    public Extra() {
    }

    public Extra(String postalAddress, String phoneNumber, String city, String zone) {
        this.postalAddress = postalAddress;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.zone = zone;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
