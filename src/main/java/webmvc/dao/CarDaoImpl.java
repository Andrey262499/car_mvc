package webmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webmvc.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(cars); // Возвращаем копию списка
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < Math.min(count, cars.size()); i++) {
            result.add(cars.get(i));
        }
        return result;
    }

    @Override
    public void saveCar(Car car) {
        cars.add(car);
    }
}
