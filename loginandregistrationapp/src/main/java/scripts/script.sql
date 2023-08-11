CREATE TABLE Sensor (
  SensorID INT PRIMARY KEY AUTO_INCREMENT,
  type VARCHAR(255),
  description VARCHAR(255)
);

CREATE TABLE Measurement (
  measurementID INT PRIMARY KEY AUTO_INCREMENT,
  value LONG,
  timestamp TIMESTAMP,
  sensorID INT,
  FOREIGN KEY (sensorID) REFERENCES Sensor(SensorID)
);

INSERT INTO Sensor (type, description) VALUES
('WATER', 'Reads soil water levels'),
('TEMPERATURE', 'Reads soil temperature levels'),
('LIGHT', 'Reads light levels');


INSERT INTO Measurement (value, timestamp, sensorID) VALUES
(40, '2023-08-04 14:30:00', 1),
(78, '2023-08-04 14:30:00', 2),
(80000, '2023-08-04 14:30:00', 3),
(46, '2023-08-04 14:30:00', 1),
(98, '2023-08-04 14:30:00', 2),
(60000, '2023-08-04 14:30:00', 3);

