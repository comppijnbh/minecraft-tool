package com.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.business.**.mapper")
public class Application {

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        System.out.println("\n\t(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ \n");

        /*Environment env = applicationContext.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(path)) {
            path = "";
        }
        System.out.println("\n----------------------------------------------------------\n\t" +
                "(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ \n" +
                "服务端地址如下： \n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "------------------------------------------------------\n\t"+
                "NetWork: \thttp://"+ip+":" + port + path + "\n\t");*/
    }

}
