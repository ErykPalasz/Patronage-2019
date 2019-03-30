package Model;

public class ModelDanych {
    private long timestamp;
    private double latitude;
    private double longitude;
    
    ModelDanych(long timestamp, double latitude, double longitude) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
}