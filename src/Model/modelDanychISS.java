package Model;

public class modelDanychISS {
    private long timestamp;
    private double latitude;
    private double longitude;
    
    modelDanychISS(long timestamp, double latitude, double longitude){
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    // getters and setters
    public long timestamp() {
        return timestamp;
    }
    public double latitude() {
        return latitude;
    }
    public double longitude() {
        return longitude;
    }
    
    @Deprecated
    void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Deprecated
    void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    @Deprecated
    void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
