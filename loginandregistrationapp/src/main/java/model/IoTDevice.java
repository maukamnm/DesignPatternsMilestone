package model;

import java.util.List;

public class Iotdevice {
    int deviceId;
    List<Measurement> dataCaptured;

    public Iotdevice() {
    }

    public Iotdevice(int deviceId, List<Measurement> dataCaptured) {
        this.deviceId = deviceId;
        this.dataCaptured = dataCaptured;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public List<Measurement> getDataCaptured() {
        return dataCaptured;
    }

    public void setDataCaptured(List<Measurement> dataCaptured) {
        this.dataCaptured = dataCaptured;
    }

    @Override
    public String toString() {
        return "IoTDevice{" +
                "deviceId=" + deviceId +
                ", dataCaptured=" + dataCaptured +
                '}';
    }
}
