package model;

import java.sql.Timestamp;


public class Measurement {
    int measurementID;
    /*
     * In terms of light measurement--
     * Moonless, overcast night sky: Around 0.001 lux
     * Full moon: Around 0.25 to 1 lux
     * Overcast day: Around 10,000 to 20,000 lux
     * Direct sunlight: Around 100,000 lux or more

     * * In terms of soil measurement--
     * Dry soil: Around 0% moisture
     * Saturated soil: 100% moisture or higher, depending on soil type
     * Typical healthy soil moisture range for plants: 20% to 80%

     *  In terms of soil temperature--
     * Optimal soil temperatures for most plants: Vary widely depending
     * on the plant species but is generally 59°F to 86°F.
     * */
    long value;

    Timestamp timeStamp;
    int sensorId;

    public Measurement() {
    }

    public Measurement(long value, Timestamp timeStamp, int sensorId) {
        this.value = value;
        this.timeStamp = timeStamp;
        this.sensorId = sensorId;
    }

    public int getMeasurementId() {
        return measurementID;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementID = measurementId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementID=" + measurementID +
                ", value=" + value +
                ", timeStamp=" + timeStamp +
                ", sensorId=" + sensorId +
                '}';
    }
}
