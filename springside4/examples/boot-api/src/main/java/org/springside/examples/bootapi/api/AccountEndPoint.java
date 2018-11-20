package org.springside.examples.bootapi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.examples.bootapi.domain.Account;
import org.springside.examples.bootapi.repository.Result;
import org.springside.examples.bootapi.service.AccountService;
import org.springside.examples.bootapi.service.exception.ErrorCode;
import org.springside.examples.bootapi.service.exception.ServiceException;
import org.springside.modules.web.MediaTypes;

import java.util.Map;

// Spring Restful MVC Controller的标识, 直接输出内容，不调用template引擎.
@RestController
@Api(value="AccountEndPoint",description = "用户接口")
public class AccountEndPoint {

	private static Logger logger = LoggerFactory.getLogger(AccountEndPoint.class);

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/api/accounts/login",produces = MediaTypes.JSON_UTF_8)
	@ApiOperation(value="用户登录",httpMethod = "GET",response = Map.class,notes="接口发布说明")
	public Result login(@RequestParam("account") String account, @RequestParam("password") String password) {

		if(StringUtils.isEmpty(account)){
			throw new ServiceException("请输入用户名", ErrorCode.BAD_REQUEST);
		}
		if(StringUtils.isEmpty(password)){
			throw new ServiceException("请输入密码", ErrorCode.BAD_REQUEST);
		}
		String token = accountService.login(account, password);
		//throw new ServiceException(token, ErrorCode.BAD_REQUEST);
		return Result.ok().put(token);
		 //Collections.singletonMap("token", token);
	}

	@RequestMapping(value = "/api/accounts/getAccounts/")
	@ApiOperation(value="获取用户",httpMethod = "GET",notes="接口发布说明")
	public Account getAccounts(@RequestParam(value = "token", required = false) String token) {
		return accountService.getLoginUser(token);
	}

	@RequestMapping(value = "/api/accounts/logout")
	@ApiOperation(value="用户退出",httpMethod = "GET",notes="接口发布说明")
	public void logout(@RequestParam(value = "token", required = false) String token) {
		accountService.logout(token);
	}

	@RequestMapping(value = "/api/accounts/register")
	@ApiOperation(value="用户注册",httpMethod = "POST",notes="接口发布说明")
	public Account register(@RequestBody Account account) {
		return accountService.register(account);
	}
}
