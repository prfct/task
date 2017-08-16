package com.my.flowersharm.dao;

import com.my.flowersharm.dao.db.DataCommand;

public abstract class AbstractDao {

    protected <T> T executeDataCommand(DataCommand<T> command) {
        return command.execute();
    }
}
