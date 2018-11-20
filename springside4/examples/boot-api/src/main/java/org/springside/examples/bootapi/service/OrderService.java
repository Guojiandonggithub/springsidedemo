package org.springside.examples.bootapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.bootapi.domain.Order;
import org.springside.examples.bootapi.repository.OrderDao;

import java.util.List;


// Spring Bean的标识.
@Service
public class OrderService {

	private static Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderDao orderDao;

	@Transactional(readOnly = true)
	public Iterable<Order> findAll(Pageable pageable) {
		return orderDao.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Order findOne(Long id) {
		return orderDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Order> findOrderListByUserid(Integer id,Pageable pageable) {
		return orderDao.findByUserId(id,pageable);
	}
}
