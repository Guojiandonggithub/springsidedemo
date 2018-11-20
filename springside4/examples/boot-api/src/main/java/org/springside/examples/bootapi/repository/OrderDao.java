package org.springside.examples.bootapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.bootapi.domain.Order;

import java.util.List;

/**
 * 基于Spring Data JPA的Dao接口, 自动根据接口生成实现.
 * 
 * PagingAndSortingRepository默认有针对实体对象的CRUD与分页查询函数.
 * 
 * Spring Data JPA 还会解释新增方法名生成新方法的实现.
 */
public interface OrderDao extends PagingAndSortingRepository<Order, Long> {

	List<Order> findByUserId(Integer userId, Pageable pageable);
}
