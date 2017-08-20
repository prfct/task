package com.my.flowersharm.dao;

import com.my.flowersharm.model.domain.Tree;

import java.util.List;

public interface TreeDao {
    Tree createTree(Tree tree);

    List<Tree> getAll();

    Tree findTreeById(Long treeId);
}
