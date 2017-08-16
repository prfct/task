package com.my.flowersharm.controller;

import com.my.flowersharm.model.domain.Tree;
import com.my.flowersharm.service.TreeService;
import com.my.flowersharm.service.impl.TreeServiceImpl;
import com.my.flowersharm.web.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeListCommand implements Command {
    private TreeService treeService = TreeServiceImpl.getInstance();

    @Override
    public String execute(Model model) {
        Map<String, Object> errors = new HashMap<>();
        List<Tree> trees = treeService.treeList();
        if (trees != null && !trees.isEmpty()) {
            model.setAttribute("trees", trees);
        } else {
            errors.put("trees_error", "There are no trees");
            model.setAttributes(errors);
        }
        return "/views/tree_list.jsp";
    }
}
