package fullApplication.IoTDeviceLogic.business;

import fullApplication.IoTDeviceLogic.dao.DAO;
import fullApplication.IoTDeviceLogic.model.IoTDevice;
import fullApplication.IoTDeviceLogic.model.Measurement;
import fullApplication.IoTDeviceLogic.model.Sensor;
import fullApplication.IoTDeviceLogic.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IoTManager implements IoTManagerInterface {

    @Override
    public List<IoTDevice> getDevices() {
        DAO dao = new DAO();
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
        DAO dao = new DAO();
        return dao.readSensors();
    }

    @Override
    public List<Measurement> getAllMeasurements() {
        DAO dao = new DAO();
        List<Measurement> measurementList = dao.readMeasurementsForAllDevices();
        measurementList.forEach(measurement -> System.out.println(measurement.toString()));
        return measurementList;
    }

    @Override
    public List<Measurement> getMeasurementsForId() {
        System.out.println("Enter an id for a sensor you would like to see the data for");
        Scanner scanner = new Scanner(System.in);
        DAO dao = new DAO();
        List<Measurement> measurementList = dao.readMeasurementsForDeviceId(Integer.parseInt(scanner.nextLine()));
        measurementList.forEach(measurement -> System.out.println(measurement.toString()));
        return measurementList;
    }

    @Override
    public void saveNewSensor() {
        System.out.println("Enter sensor type");
        Scanner scanner = new Scanner(System.in);
        DAO dao = new DAO();
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
        //todo later?
    }
}
