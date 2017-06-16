package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Service
public class DemoMethodService {
    public void methodAdd(){
        System.out.println("正在添加...");
    }
}
