package com.wisely.highlight_spring4.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by gaowenfeng on 2017/4/30.
 */
@Component
@Order(1)
public class TwoStudent implements Person{
}
