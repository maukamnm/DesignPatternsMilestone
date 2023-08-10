package fullApplication.IoTDeviceLogic.business;

import fullApplication.IoTDeviceLogic.model.IoTDevice;
import fullApplication.IoTDeviceLogic.model.Measurement;

import java.util.List;

public interface IoTManagerInterface {

    public List<IoTDevice> getDevices();

    public List<Measurement> getAllMeasurements();
    public List<Measurement> getMeasurementsForId();
    public void saveNewMeasurement(Measurement measurement);
    public void saveNewSensor();

}
