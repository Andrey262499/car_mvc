package webmvc.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webmvc.dao.CarDao;
import webmvc.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService, InitializingBean {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }

    @Override
    public List<Car> getCars(int count) {
        return carDao.getCars(Math.max(count, 1));
    }

    public void afterPropertiesSet() {
        for (int i = 0; i < 5; i++) {
            Car car = new Car("BMW", i);
            carDao.saveCar(car);
        }
    }
}
