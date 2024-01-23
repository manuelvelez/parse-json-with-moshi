public class Pharmacy {
    public Pharmacy(String name, String address, String geolocation, String images, String extra, String id) {
        this.name = name;
        this.address = address;
        this.geolocation = geolocation;
        this.images = images;
        this.extra = extra;
        this.id = id;
    }

    public String name;
    public String address;
    public String geolocation;
    public String images;
    public String extra;
    public String id;

    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", geolocation='" + geolocation + '\'' +
                ", images='" + images + '\'' +
                ", extra='" + extra + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public String getImages() {
        return images;
    }

    public String getExtra() {
        return extra;
    }

    public String getId() {
        return id;
    }
}
