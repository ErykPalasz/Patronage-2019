package Model;

public class modelDanychISS {
    private long timestamp = 0;
    private double latitude = 0;
    private double longitude = 0;
    
    // getters and setters
    public long Timestamp() {
        return timestamp;
    }
    
    void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public double Latitude() {
        return latitude;
    }
    
    void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double Longitude() {
        return longitude;
    }
    
    void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
