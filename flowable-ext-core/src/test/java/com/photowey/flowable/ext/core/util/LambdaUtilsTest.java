package com.photowey.flowable.ext.core.util;

import com.photowey.flowable.ext.core.hello.Hello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LambdaUtilsTest
 *
 * @author photowey
 * @date 2020/12/21
 * @since 1.0.0
 */
public class LambdaUtilsTest {

    @Test
    public void testTransferList() {
        List<Hello> hellos = this.populateHellos();
        List<Long> ids = LambdaUtils.transferToList(hellos, Hello::getId);
        Assertions.assertTrue(3 == ids.size(), "Error:LambdaUtils.transferList()");
        Assertions.assertTrue(1L == ids.get(0), "Error:LambdaUtils.transferList()");
        Assertions.assertTrue(2L == ids.get(1), "Error:LambdaUtils.transferList()");
        Assertions.assertTrue(2020126L == ids.get(2), "Error:LambdaUtils.transferList()");
    }

    @Test
    public void testTransferSet() {
        List<Hello> hellos = this.populateHellos();
        Set<String> names = LambdaUtils.transferToSet(hellos, Hello::getName);
        Assertions.assertTrue(2 == names.size(), "Error:LambdaUtils.transferSet()");
    }

    @Test
    public void testFindAny() {
        List<Hello> hellos = this.populateHellos();
        String any = LambdaUtils.findAny(hellos, Hello::getName);
        Assertions.assertTrue(null != any, "Error:LambdaUtils.findAny()");
        Assertions.assertEquals("photowey", any, "Error:LambdaUtils.findAny()");
    }

    @Test
    public void testFilter() {
        List<Hello> hellos = this.populateHellos();
        List<Hello> helloList = LambdaUtils.filter(hellos, hello -> "photowey".equals(hello.getName()));
        Assertions.assertTrue(null != helloList, "Error:LambdaUtils.filter()");
        Assertions.assertTrue(2 == helloList.size(), "Error:LambdaUtils.filter()");
        Assertions.assertEquals("photowey", helloList.get(0).getName(), "Error:LambdaUtils.filter()");

        Hello notExist = LambdaUtils.filterAny(hellos, hello -> "shark-chili".equals(hello.getName()));
        Assertions.assertTrue(null == notExist, "Error:LambdaUtils.filterAny()");

        List<Hello> mambaList = LambdaUtils.filter(hellos, hello -> "mamba".equals(hello.getName()));
        Assertions.assertTrue(null != mambaList, "Error:LambdaUtils.filter()");
        Assertions.assertTrue(1 == mambaList.size(), "Error:LambdaUtils.filter()");
        Assertions.assertEquals("mamba", mambaList.get(0).getName(), "Error:LambdaUtils.filter()");
    }

    @Test
    public void testFilterAny() {
        List<Hello> hellos = this.populateHellos();
        Hello any = LambdaUtils.filterAny(hellos, hello -> "photowey".equals(hello.getName()));
        Assertions.assertTrue(null != any, "Error:LambdaUtils.filterAny()");
        Assertions.assertEquals("photowey", any.getName(), "Error:LambdaUtils.filterAny()");

        Hello notExist = LambdaUtils.filterAny(hellos, hello -> "shark-chili".equals(hello.getName()));
        Assertions.assertTrue(null == notExist, "Error:LambdaUtils.filterAny()");
    }

    private List<Hello> populateHellos() {
        List<Hello> hellos = new ArrayList<>();
        Hello hello1 = new Hello(1L, "photowey");
        Hello hello2 = new Hello(2L, "photowey");
        Hello hello3 = new Hello(2020126L, "mamba");
        hellos.add(hello1);
        hellos.add(hello2);
        hellos.add(hello3);
        return hellos;
    }

    public List<Integer> copy(List<Integer> temps) {
        List<Integer> collect = temps.stream().map(temp -> temp).collect(Collectors.toList());
        return collect;
    }

}