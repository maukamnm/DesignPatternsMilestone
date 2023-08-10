//import milestone.model.Measurement;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import static org.junit.Assert.assertNotNull;
//
//public class TestHibernateNoRollback {
//
//    private SessionFactory sessionFactory;
//    private Session session;
//    private Transaction transaction;
//
//    @Before
//    public void setUp() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml"); // Use the test configuration
//        sessionFactory = configuration.buildSessionFactory();
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//    }
//
//    @Test
//    public void testMeasurementAdd() {
//        //water measurement
//        Measurement measurement = new Measurement(79, new Timestamp(System.currentTimeMillis()), 1);
//        session.save(measurement);
//    }
//    @Test
//    public void testMeasurementRead() {
//        Query<Measurement> query = session.createQuery("FROM measurement", Measurement.class);
//        List<Measurement> measurementList = query.getResultList();
//        assertNotNull(measurementList);
//        for (Measurement measurement : measurementList) {
//            System.out.println("Sensor: " + measurement.getSensorId() +
//                    " has the reading of: " + measurement.getMeasurementId());
//        }    }
//}
