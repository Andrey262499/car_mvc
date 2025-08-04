package webmvc.dao;

import webmvc.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars();
    List<Car> getCars(int count);
    void saveCar(Car car);
}
