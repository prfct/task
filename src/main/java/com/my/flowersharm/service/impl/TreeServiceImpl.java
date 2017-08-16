package com.my.flowersharm.service.impl;

import com.my.flowersharm.dao.DaoFactory;
import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.exception.TreeListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TreeServiceImpl implements TreeService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private DaoFactory daoFactory = DaoFactory.getFactory();

    private TreeServiceImpl() {
    }

    private static class InstanceHolder {
        private static final TreeServiceImpl INSTANCE = new TreeServiceImpl();
    }

    public static TreeService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public List<Tree> treeList() {
        List<Tree> trees = daoFactory.getTreeDao().getAll();
        if (trees.isEmpty()) {
            LOGGER.warn("Service.There are no trees");
        }
        LOGGER.info("Service. trees size '{}'", trees.size());
        return trees;
    }

    @Override
    public Tree createTree(Tree tree) {
        Tree createdTree = daoFactory.getTreeDao().createTree(tree);
        LOGGER.info("Service.Tree with id '{}', name '{}', size '{}'successful created",
                createdTree.getId(), createdTree.getName(), createdTree.getSize());
        return createdTree;
    }
}
