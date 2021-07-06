package opera.app.spring.dao;

import java.util.List;
import opera.app.spring.model.Order;
import opera.app.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
