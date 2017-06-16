package com.wisely.highlight_spring4.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Service
public class DemoService {
    @Value("其他类的属性")
    private String anothor;

    public String getAnothor() {
        return anothor;
    }

    public void setAnothor(String anothor) {
        this.anothor = anothor;
    }
}
