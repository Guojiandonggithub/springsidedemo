package org.springside.examples.bootapi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// JPA实体类的标识
@Entity
public class Account {

	// JPA 主键标识, 策略为由数据库生成主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String nickname;
	public String realname;
	public String email;
	public String name;
	public String password;

	public Account() {

	}

	public Account(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
