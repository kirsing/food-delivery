package com.kirsing.orders.service;


import com.kirsing.orders.dto.OrderDTO;
import com.kirsing.orders.dto.OrderDTOFromFE;
import com.kirsing.orders.dto.UserDTO;
import com.kirsing.orders.entity.Order;
import com.kirsing.orders.mapper.OrderMapper;
import com.kirsing.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;



    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = null;
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.mapToOrderDto(orderToBeSaved, new OrderDTO());
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USERINFO/user/fetchUserById/" + userId, UserDTO.class);
    }
}
