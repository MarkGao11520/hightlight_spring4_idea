package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by gaowenfeng on 2017/2/2.
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
