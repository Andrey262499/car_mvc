package webmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webmvc.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Car> getCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car", Car.class).getResultList();
    }

    @Transactional
    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return getCars();
        }
        return sessionFactory.getCurrentSession().createNativeQuery("select * from cars limit " + count, Car.class).getResultList();
    }

    @Transactional
    public void saveCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
