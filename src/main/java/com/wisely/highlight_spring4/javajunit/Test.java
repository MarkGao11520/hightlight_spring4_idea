package com.wisely.highlight_spring4.javajunit;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Before;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/4/24.
 */
public class Test {

    private Service service = new Service();
    List<Model> list;

    @Before
    public void Before(){
        list = new ArrayList<Model>();
        /**判定覆盖**/
//        list.add(new Model(2,0,2));
//        list.add(new Model(2,1,2));

        /**条件覆盖**/
        list.add(new Model(2,0,4));
        list.add(new Model(1,1,1));
    }



    @org.junit.Test
    public void testService(){
        for (Model model:list) {
            System.out.println(service.techee(model.getA(),model.getB(),model.getX()));
//            Assert.assertSame("期望值与预期值不等",1,service.techee(model.getA(),model.getB(),model.getX()));
        }
    }

}
