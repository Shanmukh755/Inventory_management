package com.example.inventory.services;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
            .map(order -> {
                order.setCustomerId(updatedOrder.getCustomerId());
                order.setOrderDate(updatedOrder.getOrderDate());
                order.setStatus(updatedOrder.getStatus());
                return orderRepository.save(order);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
