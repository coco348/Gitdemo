package service;

import entity.GouponEvent;
import entity.Order;
import entity.Position;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("OderService")
public class OrderService {
    private static int nextOrderId = 1;
    private static Map<Integer, Order > OrderDB=new HashMap<>();
    //新增订单
   @Path("orders")
    @POST
    public Order add(Order order) {
       order.setOrderNumber(nextOrderId++);
       OrderDB.put(order.getOrderNumber(),order);
       return order;

   }
//删除订单
    @Path("orders/{orderNumber}")
   @DELETE
    public Order remove(@PathParam("orderNumber") int Id) {

        Order order=OrderDB.remove(Id);
        return order;
   }
//查找订单
    @Path("orders/{orderNumber}")
    @GET
    public Order getOrderById(@PathParam("orderNumber") int Id) {
        Order order=new Order();
        order.setOrderNumber(Id);

        Position position1=new Position();
        position1.setPositionId(1);
        position1.setArticleName("Soy Sauce");
        position1.setPrice(3.99);
        position1.setQuantity(12);
        Position position2=new Position();
        position2.setPositionId(2);
        position2.setArticleName("Tofu");
        position2.setPrice(2.99);
        position2.setQuantity(5);
        ArrayList<Position> positions=new ArrayList<>();
        positions.add(position1);
        positions.add(position2);
        order.setList(positions);
        double summe=0.00;
       for(int i=0;i<positions.size();i++){
           summe=summe+positions.get(i).getPrice()*positions.get(i).getQuantity();
       }
        order.setTotalPrice(summe);
        return order;
    }
    //更改订单
   @Path("orders/{orderNumber}")
    @PUT
   public Order update(@PathParam("orderNumber") int Id, Order newData) {
       OrderDB.replace(Id,newData);
       return newData;
   }
   //查看所有订单
   @Path("orders")
   @GET
   public Collection<Order> getAllOrders() {
       return OrderDB.values();

   }

}
