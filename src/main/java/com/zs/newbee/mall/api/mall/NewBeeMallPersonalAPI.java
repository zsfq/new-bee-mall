package com.zs.newbee.mall.api.mall;

import com.zs.newbee.mall.api.mall.param.MallUserLoginParam;
import com.zs.newbee.mall.api.mall.param.MallUserRegisterParam;
import com.zs.newbee.mall.common.Constants;
import com.zs.newbee.mall.common.ServiceResultEnum;
import com.zs.newbee.mall.services.NewBeeMallUserService;
import com.zs.newbee.mall.utils.NumberUtil;
import com.zs.newbee.mall.utils.Result;
import com.zs.newbee.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(value = "v1", tags = "2.新蜂商城用户操作相关接口")
@RequestMapping("/api/v1")
public class NewBeeMallPersonalAPI {

    @Resource
    private NewBeeMallUserService newBeeMallUserService;

    private static final Logger logger = LoggerFactory.getLogger(NewBeeMallPersonalAPI.class);

    public Result<String> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam){
        if(!NumberUtil.isPhoneNumber(mallUserLoginParam.getLoginName())){
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }
        String loginResult = newBeeMallUserService.login(mallUserLoginParam.getLoginName(), mallUserLoginParam.getPasswordMd5());
        logger.info("login api,loginName={},loginResult={}", mallUserLoginParam.getLoginName(), loginResult);

        //登录成功
        if(StringUtils.hasText(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH){
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }

        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "")
    public Result register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam){
        if(!NumberUtil.isPhoneNumber(mallUserRegisterParam.getLoginName())){
            ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }
        String registerResult = newBeeMallUserService.register(mallUserRegisterParam.getLoginName(), mallUserRegisterParam.getPassword());
        logger.info("register api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), registerResult);
        //注册成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //注册失败
        return ResultGenerator.genFailResult(registerResult);
    }
}
