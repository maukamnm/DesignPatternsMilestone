package business;

import model.IoTDevice;
import model.Measurement;

import java.util.List;

public interface IoTManagerInterface {

    public List<IoTDevice> getDevices();

    public List<Measurement> getAllMeasurements();
    public List<Measurement> getMeasurementsForId();
    public void saveNewMeasurement(Measurement measurement);
    public void saveNewSensor();

}