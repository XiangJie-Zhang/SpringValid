package top.awslzhang.validation.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.awslzhang.validation.common.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("base")
@Validated
public class TestBaseController {

    @GetMapping("testNotNull")
    @ApiOperation(value = "notNull检验！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testString", value = "字符串",required = true, dataType =
                    "String",
            paramType = "query", example = "132"),
            @ApiImplicitParam(name = "testString1", value = "字符串1",required = true, dataType =
                    "String",
                    paramType = "query", example = "132")
    })
    public ResponseEntity<String> testNotNull(@NotNull(message = "testString不能为null") String testString,
                                              @NotNull(message = "testString1不能为null") String testString1){
        return ResponseEntity.ok("参数校验成功");
    }


    @GetMapping("testNotBlank")
    @ApiOperation(value = "notBlank检验！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testString", value = "字符串",required = true, dataType =
                    "String",
                    paramType = "query", example = "132")
    })
    public ResponseEntity<String> testNotBlank(@NotBlank String testString){
        return ResponseEntity.ok("参数校验成功");
    }
}
