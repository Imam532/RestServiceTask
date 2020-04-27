package ru.shara.restexample.service;

import ru.shara.restexample.model.Data;

public interface DataService {
    Data[] getDataArray(String analysisString);
}
