package fullApplication.IoTDeviceLogic.dao;

import fullApplication.IoTDeviceLogic.model.Measurement;
import fullApplication.IoTDeviceLogic.model.Sensor;
import fullApplication.IoTDeviceLogic.model.Type;
import fullApplication.IoTDeviceLogic.service.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

//    public void saveNewSensor(Measurement measurement) {
//        // Initialize Hibernate configuration
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        // Open a session
//        Session session = sessionFactory.openSession();
//        // Create and persist an object
//        Transaction tx = session.beginTransaction();
//        session.save(measurement);
//
//        tx.commit();
//
//        // Close the session and session factory
//        session.close();
//        sessionFactory.close();
//    }

       static Connection conn;
    public boolean saveNewMeasurement(Measurement sensorMeasurement) {
        conn = JDBCConnection.connectToDatabase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into Measurement values (" + sensorMeasurement.getValue());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean saveNewSensor(Sensor sensor) {
        conn = JDBCConnection.connectToDatabase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into Sensor (type, description) VALUES ("
                    + sensor.getSensorType() + ", " + sensor.getDescription() + ")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Measurement> readMeasurementsForDeviceId(int deviceId) {
        conn = JDBCConnection.connectToDatabase();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Measurement> measurements = new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM measurement where measurementID = " + deviceId;
            stmt = conn.prepareStatement(selectSql);
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Measurement measurement = new Measurement();
                    measurement.setMeasurementId(resultSet.getInt("measurementID"));
                    measurement.setSensorId(resultSet.getInt("sensorID"));
                    measurement.setValue(resultSet.getLong("value"));
                    measurement.setTimeStamp(resultSet.getTimestamp("timestamp"));
                    measurements.add(measurement);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return measurements;
    }
    public List<Measurement> readMeasurementsForAllDevices() {
        conn = JDBCConnection.connectToDatabase();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Measurement> measurements = new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM measurement";
            stmt = conn.prepareStatement(selectSql);
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Measurement measurement = new Measurement();
                    measurement.setMeasurementId(resultSet.getInt("measurementID"));
                    measurement.setSensorId(resultSet.getInt("sensorID"));
                    measurement.setValue(resultSet.getLong("value"));
                    measurement.setTimeStamp(resultSet.getTimestamp("timestamp"));
                    measurements.add(measurement);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return measurements;
    }

    public List<Sensor> readSensors() {
        conn = JDBCConnection.connectToDatabase();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sensor> measurements = new ArrayList<>();
        try {
            String selectSql = "SELECT * from Sensor";
            stmt = conn.prepareStatement(selectSql);
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Sensor sensor = new Sensor();
                    sensor.setSensorId(resultSet.getInt("sensorID"));
                    sensor.setSensorType(Type.valueOf(resultSet.getString("type")));
                    sensor.setDescription(resultSet.getString("description"));
                    measurements.add(sensor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return measurements;
    }

        public boolean readSensorList(Measurement sensorMeasurement) {
        conn = JDBCConnection.connectToDatabase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into Measurement values (" + sensorMeasurement.getValue());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean readSensorById(Measurement sensorMeasurement) {
        conn = JDBCConnection.connectToDatabase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into Measurement values (" + sensorMeasurement.getValue());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
