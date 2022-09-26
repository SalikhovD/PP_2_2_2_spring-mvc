package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class AppServiceImpl implements AppService {

    List<Car> carList;

    public AppServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "M3", 350));
        carList.add(new Car("KIA", "Rio X", 108));
        carList.add(new Car("Porsche", "911", 380));
        carList.add(new Car("Lada", "2107", 85));
        carList.add(new Car("MINI", "Cooper", 160));
    }

    @Override
    public List<Car> getCarList(Integer count) {
        if (count != null) {
            return carList.stream().limit(count).toList();
        } else {
            return carList;
        }
    }

    @Override
    public List<String> getWelcomeMessagesList() {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        return messages;
    }
}
