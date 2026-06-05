package com.demo.order.service.impl;

import com.demo.order.entity.Order;
import com.demo.order.service.OrderService;
import com.demo.goods.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    // 初始化订单集合
    private static final Map<Integer, Order> orderMap = new HashMap<>();

    static {
        Order order1 = new Order(1, 1, "2020-11-11 00:01");
        Order order2 = new Order(2, 2, "2020-11-11 00:02");
        Order order3 = new Order(3, 3, "2020-11-11 00:03");
        orderMap.put(order1.getId(), order1);
        orderMap.put(order2.getId(), order2);
        orderMap.put(order3.getId(), order3);
    }

    // 自动注入 RestTemplate 对象
    @Autowired
    private RestTemplate restTemplate;

    // 调用商品服务，根据商品 ID 查询商品详情
    private Goods findGoodsById(Integer id) {
        // 使用 RestTemplate 访问商品服务的查询接口
        ResponseEntity<Goods> responseEntity =
                restTemplate.getForEntity("http://GOODS2/goods/one?id=" + id, Goods.class);
        return responseEntity.getBody();
    }

    @Override
    public List findAll() {
        // 定义要返回的订单集合
        List<HashMap<String, Object>> orderList = new ArrayList<>();

        // 遍历初始化的订单集合
        orderMap.forEach((k, v) -> {
            // 调用 findGoodsById 方法获取相应 ID 的商品对象
            Goods goods = findGoodsById(v.getGoodsId());

            // 定义包含商品信息的订单信息
            HashMap<String, Object> order = new HashMap<>();
            order.put("订单 ID", k);
            order.put("下单时间", v.getTime());
            order.put("商品 ID", v.getGoodsId());
            order.put("商品名称", goods.getName());
            order.put("商品价格", goods.getPrice());

            // 将订单信息添加到要返回的订单集合中
            orderList.add(order);
        });

        // 返回订单集合
        return orderList;
    }

    @Override
    public Object findById(Integer id) {
        // 获取相应 ID 的订单对象
        Order o = orderMap.get(id);
        // 调用 findGoodsById 方法获取相应 ID 的商品对象
        Goods goods = findGoodsById(o.getGoodsId());
        // 定义要返回的包含商品信息的订单信息
        HashMap<String, Object> order = new HashMap<>();
        order.put("订单 ID", id);
        order.put("下单时间", o.getTime());
        order.put("商品 ID", o.getGoodsId());
        order.put("商品名称", goods.getName());
        order.put("商品价格", goods.getPrice());
        // 返回订单信息
        return order;
    }
}