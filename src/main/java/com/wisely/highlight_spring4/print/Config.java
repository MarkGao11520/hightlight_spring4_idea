package com.wisely.highlight_spring4.print;

import org.springframework.context.annotation.Bean;

/**
 * Created by gaowenfeng on 2017/3/23.
 */

public class Config {
    @Bean
    public ink ink(){
        return new BlackInk();
    }

    @Bean
    public pager pager(){
        return new B5Page();
    }



    @Bean
    public Printer printer(){
        Printer printer = new Printer();
        printer.setInk(ink());
        printer.setPager(pager());
        return printer;
    }
}
