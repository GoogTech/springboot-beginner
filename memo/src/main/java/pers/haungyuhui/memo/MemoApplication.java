package pers.haungyuhui.memo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("pers.haungyuhui.memo.dao") //扫描Mapper接口
@EnableCaching //开启Redis缓存
public class MemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MemoApplication.class, args);
    }

}