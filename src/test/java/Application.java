import exercises.mapping.hibernate.AirForce;
import exercises.mapping.hibernate.ArmedForce;
import exercises.mapping.hibernate.Army;
import exercises.mapping.hibernate.Naval;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Application {

    @Test
    public void armyTest()
    {
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        Army army=new Army();
        army.setName("Army of USA");
        army.setBudget(598);
        session.save(army);

        AirForce airForce=new AirForce();
        airForce.setJetName("F-22.Raptor");
        airForce.setSpeed(2460);
        airForce.setName("United States Air Force");
        airForce.setBudget(156);
        session.save(airForce);

        Naval naval=new Naval();
        naval.setShipNames("USS Abraham Lincoln");
        naval.setDisplacement(105783);
        naval.setName("United States Navy");
        naval.setBudget(142);
        session.save(naval);

        ArmedForce armedForce=new ArmedForce();
        armedForce.setTankName("M1A1 Abrams");
        armedForce.setArmor(1000);
        armedForce.setName("United States Armed Forces");
        armedForce.setBudget(244);
        session.save(armedForce);

        transaction.commit();;
        session.close();

        session=factory.openSession();
        session.setDefaultReadOnly(true);
        transaction=session.beginTransaction();

        Army army1=(Army) session.load(Army.class, army.getId());
        assertEquals(army1.getName(), army.getName());

        AirForce airForce1=(AirForce) session.load(AirForce.class, airForce.getId());
        assertEquals(airForce1.getName(), airForce.getName());

        Naval naval1=(Naval) session.load(Naval.class, naval.getId());
        assertEquals(naval1.getName(), naval.getName());

        transaction.commit();
        session.close();

    }
}
