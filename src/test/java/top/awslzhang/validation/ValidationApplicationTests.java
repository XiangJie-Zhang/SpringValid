package top.awslzhang.validation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootTest
class ValidationApplicationTests {

    @Test
    void contextLoads() {
        String[] a = {"1","23","444"};
        String collect = Arrays.stream(a).collect(Collectors.joining(","));
        System.out.println(collect);
    }

}
