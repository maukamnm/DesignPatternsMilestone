package business;

import model.Iotdevice;
import model.Measurement;

import java.util.List;

public interface IoTManagerInterface {

    public List<Iotdevice> getDevices();

    public List<Measurement> getAllMeasurements();
    public List<Measurement> getMeasurementsForId();
    public void saveNewMeasurement(Measurement measurement);
    public void saveNewSensor();

}
