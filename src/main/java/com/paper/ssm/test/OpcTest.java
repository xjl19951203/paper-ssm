package com.paper.ssm.test;

import com.paper.ssm.SsmApplication;
import com.paper.ssm.face.opc.ClientRunner;
import com.paper.ssm.face.opc.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @className: Test
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 15:42
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
public class OpcTest {

    @Resource
    ClientService clientService;

    @Test
    public void readAndWrite(){
        new ClientRunner(this.clientService).run();
    }

}
