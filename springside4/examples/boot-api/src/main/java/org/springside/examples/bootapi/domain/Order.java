package org.springside.examples.bootapi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

// JPA实体类的标识
@Entity
public class Order {

	// JPA 主键标识, 策略为由数据库生成主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	//@ManyToOne
	//@JoinColumn(name = "userId")
	//public Account owner;

	public Integer userId;
	public String orderSN;
	public String address;
	public String totalPrice;
	public String postFee;
	public String payFee;
	public String youhuis;
	public String trade_no;
	public String remark;

	public Order() {

	}

	public Order(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
