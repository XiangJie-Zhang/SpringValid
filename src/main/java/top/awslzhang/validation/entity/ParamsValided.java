package top.awslzhang.validation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.awslzhang.validation.valid.FirstGroup;
import top.awslzhang.validation.valid.SecondGroup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "ParamsValided")
public class ParamsValided {
    @ApiModelProperty(name = "字符串")
    @NotNull(message = "测试字符串不得为空，可以为\"\"", groups = {FirstGroup.class})
    @NotBlank(message = "测试字符串不得为空,不可以没有内容", groups = {SecondGroup.class})
    private String testString;

    @ApiModelProperty(name = "数字")
    @NotNull(message = "测试数字不得为空，可以为\"\"", groups = {FirstGroup.class, SecondGroup.class})
    private Long testLong;

    @ApiModelProperty(name = "邮箱")
    @Email(message = "格式必须为邮箱！", groups = {FirstGroup.class})
    private String testEmail;
}
