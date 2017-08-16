package com.my.flowersharm.service;

import com.my.flowersharm.model.domain.Accessories;
import com.my.flowersharm.service.exception.AccessoriesListException;
import com.my.flowersharm.service.exception.ExistAccessoryException;

import java.util.List;

public interface AccessoriesService {
    List<Accessories> accessoriesList();

    Accessories createAccessories(Accessories accessories) throws ExistAccessoryException;
}
