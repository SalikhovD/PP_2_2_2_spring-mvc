package web.service;

import web.model.Car;

import java.util.List;

public interface AppService {

    List<Car> getCarList(Integer count);

    List<String> getHelloMessagesList();
}
