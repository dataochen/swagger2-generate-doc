package com.dt.thf.tr;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BootstrapApplication.class)
@SpringBootTest
public class TestBase {
    @BeforeClass
    public static void before() {
        System.out.println("###test start success");
    }

    @Test
    public void test() {
        System.out.println("###test start success");
    }
}