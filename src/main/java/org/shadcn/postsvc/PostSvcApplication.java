package org.shadcn.postsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostSvcApplication.class, args);
    }
}
