package along.com.library.entity;

public  class Gps {

    public double lat;
    public double lon;

    public Gps(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void print() {
        System.out.println(this.lon + "," + this.lat);
    }
}

