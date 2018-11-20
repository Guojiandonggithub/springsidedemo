package org.springside.examples.bootapi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.examples.bootapi.domain.Account;
import org.springside.examples.bootapi.domain.Order;
import org.springside.examples.bootapi.dto.OrderDto;
import org.springside.examples.bootapi.service.AccountService;
import org.springside.examples.bootapi.service.OrderService;
import org.springside.modules.utils.mapper.BeanMapper;
import org.springside.modules.web.MediaTypes;

import java.util.List;

// Spring Restful MVC Controller的标识, 直接输出内容，不调用template引擎.
@RestController
@Api(value="OrderPoint",description = "订单接口")
public class OrderPoint {

	private static Logger logger = LoggerFactory.getLogger(OrderPoint.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/api/getOrderList", produces = MediaTypes.JSON_UTF_8)
	@ApiOperation(value="根据用户id获取订单列表",httpMethod = "GET",notes="接口发布说明")
	public List<OrderDto> getOrderList(@RequestParam(value = "token", required = false) String token,
											Pageable pageable) {
		Account currentUser = accountService.getLoginUser(token);
		List<Order> orderList = orderService.findOrderListByUserid(currentUser.id, pageable);
		return BeanMapper.mapList(orderList, OrderDto.class);
	}


}
