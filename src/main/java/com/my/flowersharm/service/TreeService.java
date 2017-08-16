package com.my.flowersharm.service;

import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.exception.TreeListException;

import java.util.List;

public interface TreeService {
    List<Tree> treeList();

    Tree createTree(Tree tree);
}
