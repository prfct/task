package com.my.flowersharm.dao.impl;

import com.my.flowersharm.dao.AbstractDao;
import com.my.flowersharm.dao.TreeDao;
import com.my.flowersharm.dao.commands.InsertTree;
import com.my.flowersharm.dao.commands.SelectAllTree;
import com.my.flowersharm.dao.commands.SelectTreeById;
import com.my.flowersharm.model.domain.Tree;

import java.util.List;

public class TreeDaoImpl extends AbstractDao implements TreeDao {

    @Override
    public Tree createTree(Tree tree) {
        return executeDataCommand(new InsertTree(tree));
    }

    @Override
    public List<Tree> getAll() {
        return executeDataCommand(new SelectAllTree());
    }

    @Override
    public Tree findTreeById(Long treeId) {

        return executeDataCommand(new SelectTreeById(treeId));
    }
}
