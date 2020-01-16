package Remote.TestService;

//import org.junit.Test;

import Remote.client.RemoteInvoker;

/**
 * @author zoujianglin
 * @date 2018/8/4 9:51
 */
public class TestRPC {
//    @Test
    public void testRPC() {

        RemoteInvoker remoteInvoker = new RemoteInvoker((short) 1, hello.class, "Random");
        hello service = (hello) remoteInvoker.getProxy();
        String test = service.say();
        System.out.println(test + "返回的值是");


    }


}
