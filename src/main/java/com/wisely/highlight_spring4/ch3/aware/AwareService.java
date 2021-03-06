package com.wisely.highlight_spring4.ch3.aware;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by gaowenfeng on 2017/2/3.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;
    private ResourceLoader loader;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean的名称为: "+beanName);
//        Resource resource = loader.getResource("classpath:com/wisely/highlight_spring4/ch3/aware/test.txt");
//        try {
//            System.out.println("ResourceLoader 价值的文件内容为: "+IOUtils.toString(resource.getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }




}
