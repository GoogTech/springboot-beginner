package pers.huangyuhui.memo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.huangyuhui.memo.dao") //扫描Mapper接口
public class MemoApplication {

    public static void main(String[] args) { SpringApplication.run(MemoApplication.class, args); }

}