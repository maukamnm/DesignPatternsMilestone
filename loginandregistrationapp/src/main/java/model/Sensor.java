package model;


public class Sensor {
    int sensorId;
    Type sensorType;
    String description;

    public Sensor(int sensorId, Type sensorType, String description) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.description = description;
    }

    public Sensor() {
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public Type getSensorType() {
        return sensorType;
    }

    public void setSensorType(Type sensorType) {
        this.sensorType = sensorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
