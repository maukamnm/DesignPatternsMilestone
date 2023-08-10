package fullApplication.IoTDeviceLogic.model;

import java.util.List;

public class IoTDevice {
    int deviceId;
    List<Measurement> dataCaptured;

    public IoTDevice() {
    }

    public IoTDevice(int deviceId, List<Measurement> dataCaptured) {
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
