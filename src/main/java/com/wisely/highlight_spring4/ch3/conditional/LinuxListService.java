package com.wisely.highlight_spring4.ch3.conditional;

import com.wisely.highlight_spring4.ch3.conditional.ListService;

/**
 * Created by gaowenfeng on 2017/2/3.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
