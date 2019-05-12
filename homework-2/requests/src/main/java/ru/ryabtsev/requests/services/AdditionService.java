package ru.ryabtsev.requests.services;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    public int add(int first, int second) {
        return first + second;
    }

}
