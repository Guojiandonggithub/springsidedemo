package org.springside.examples.bootapi.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

// JPA实体类的标识
public class OrderDto {

	public Integer id;
	public String userId;
	public String orderSN;
	public String order_status;
	public String payment_status;
	public String shipping_status;
	public String address;
	public String totalPrice;
	public String postFee;
	public String payFee;
	public String youhuis;
	public String coupon_name;
	public String coupon_money;
	public String user_coupon_id;
	public String trade_no;
	public String remark;
	public String createTime;
	public String active;

	public OrderDto() {

	}

	public OrderDto(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
