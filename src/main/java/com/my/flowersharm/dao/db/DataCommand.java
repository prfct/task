package com.my.flowersharm.dao.db;

import com.my.flowersharm.dao.exception.DaoException;

public interface DataCommand<T> {
    T execute();
}
