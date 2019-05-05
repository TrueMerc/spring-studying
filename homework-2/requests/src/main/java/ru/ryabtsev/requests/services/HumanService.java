package ru.ryabtsev.requests.services;

import org.springframework.stereotype.Service;
import ru.ryabtsev.requests.entities.Human;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService {

    public List<Human> getHumanList() {
        List<Human> result = new ArrayList<>();

        result.add(new Human("Ivan", "Ivanov", 47));
        result.add(new Human("Petr", "Petrov", 28));
        result.add(new Human("Fedor", "Sidorov", 36));

        return result;
    }

}
