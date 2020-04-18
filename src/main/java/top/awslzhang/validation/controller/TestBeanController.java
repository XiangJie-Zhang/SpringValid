package top.awslzhang.validation.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import top.awslzhang.validation.common.ResponseEntity;
import top.awslzhang.validation.entity.ParamsValided;
import top.awslzhang.validation.valid.FirstGroup;
import top.awslzhang.validation.valid.SecondGroup;

@RestController
@RequestMapping("bean")
public class TestBeanController {

    @GetMapping("testNotNull")
    @ApiOperation(value = "notNull检验！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testString", value = "字符串",required = true, dataType =
                    "String",
            paramType = "query", example = "132"),
            @ApiImplicitParam(name = "testLong", value = "数字",required = true, dataType = "Long",
                    paramType = "query", example = "132"),
            @ApiImplicitParam(name = "testEmail", value = "邮箱",required = true, dataType = "String",
                    paramType = "query", example = "132"),
    })
    public ResponseEntity<String> testNotNull(@ApiIgnore @Validated(FirstGroup.class) ParamsValided paramsValided){
        return ResponseEntity.ok("参数校验成功");
    }


    @GetMapping("testNotBlank")
    @ApiOperation(value = "notBlank检验！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testString", value = "字符串",required = true, dataType =
                    "String",
                    paramType = "query", example = "132"),
            @ApiImplicitParam(name = "testLong", value = "数字",required = true, dataType = "Long",
                    paramType = "query", example = "132"),
    })
    public ResponseEntity<String> testNotBlank(@ApiIgnore @Validated(SecondGroup.class) ParamsValided paramsValided){
        return ResponseEntity.ok("参数校验成功");
    }
}
