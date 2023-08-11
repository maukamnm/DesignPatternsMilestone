package business;

import dao.IoTDao;
import model.IoTDevice;
import model.Measurement;
import model.Sensor;
import model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IoTManager implements IoTManagerInterface {

    @Override
    public List<IoTDevice> getDevices() {
        IoTDao dao = new IoTDao();
        List<IoTDevice> devices = new ArrayList<>();
        List<Measurement> measurementList = dao.readMeasurementsForAllDevices();
        List<Sensor> sensorList = dao.readSensors();
        for (Sensor sensor : sensorList){
            IoTDevice device = new IoTDevice();
            device.setDeviceId(sensor.getSensorId());
            device.setDataCaptured(measurementList.stream().filter(measure -> measure.getSensorId() == sensor.getSensorId()).toList());
            devices.add(device);
        }
        devices.forEach(device -> System.out.println(device.toString()));
        return devices;
    }

    public List<Sensor> getSensors() {
        IoTDao dao = new IoTDao();
        return dao.readSensors();
    }

    @Override
    public List<Measurement> getAllMeasurements() {
        IoTDao dao = new IoTDao();
        List<Measurement> measurementList = dao.readMeasurementsForAllDevices();
        measurementList.forEach(measurement -> System.out.println(measurement.toString()));
        return measurementList;
    }

    @Override
    public List<Measurement> getMeasurementsForId() {
        System.out.println("Enter an id for a sensor you would like to see the data for");
        Scanner scanner = new Scanner(System.in);
        IoTDao dao = new IoTDao();
        List<Measurement> measurementList = dao.readMeasurementsForDeviceId(Integer.parseInt(scanner.nextLine()));
        measurementList.forEach(measurement -> System.out.println(measurement.toString()));
        return measurementList;
    }

    @Override
    public void saveNewSensor() {
        System.out.println("Enter sensor type");
        Scanner scanner = new Scanner(System.in);
        IoTDao dao = new IoTDao();
        Sensor sensor = new Sensor();
        sensor.setSensorType(Type.valueOf(scanner.nextLine()));
        System.out.println("Enter description for the sensor");
        sensor.setDescription(scanner.nextLine());
        boolean success = dao.saveNewSensor(sensor);
        System.out.println(!success ? "Add sensor failed" : "Add sensor success");
        System.out.println("This sensor was added: " + sensor.toString());
    }

    @Override
    public void saveNewMeasurement(Measurement measurement) {
        // For Future
    }
}
