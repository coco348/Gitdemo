package service;

import entity.GouponEvent;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("GroupOnEvents")
public class EventService {

    private static int nextEventId = 1;
    private static Map<Integer, GouponEvent > GouponEventDB=new HashMap<>();  // kann als interne Datenbank verwendet werden

   @Path("events")
    @POST
    public GouponEvent add(GouponEvent g) {
        g.setEventId(nextEventId++);
        GouponEventDB.put(g.getEventId(),g);
         return g;
        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
        //throw new IllegalStateException("method 'matriculate' needs to be implemented first");

   }
    @Path("events/{eventId}")
    @DELETE
    public GouponEvent remove(@PathParam("eventId") int Id) {
        GouponEvent gouponEvent=GouponEventDB.remove(Id);
        return gouponEvent;
        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
        //throw new IllegalStateException("method 'exmatriculate' needs to be implemented first");

    }

    @Path("events/{eventId}")
    @GET
    public GouponEvent getStudentById(@PathParam("eventId") int Id) {

        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
            Statement statement=connection.createStatement();
            String query="select * from grouponevent where eventId="+Id;
            ResultSet resultSet=statement.executeQuery(query);
            boolean exist=resultSet.first();
            if(exist){
                GouponEvent event=new GouponEvent();
                String name=resultSet.getString("name");
                event.setName(name);
                String description=resultSet.getString("description");
                event.setDescription(description);
                String date=resultSet.getString("datum");
                event.setDate(date);
                String pickupAddress=resultSet.getString("pickupAdress");
                event.setPickupAddress(pickupAddress);
                return event;
            }
            else{
                System.out.println("es existiert nicht!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
        //throw new IllegalStateException("method 'getStudentById' needs to be implemented first");

    }
    @Path("events/{eventId}")
    @PUT
    public GouponEvent update(@PathParam("eventId") int Id, GouponEvent newData) {
            GouponEventDB.replace(Id,newData);
        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
        //throw new IllegalStateException("method 'updateStudentAccount' needs to be implemented first");
return newData;
   }
    @Path("events")
    @GET
   public Collection<GouponEvent> getAllEvents() {
return GouponEventDB.values();
        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
        //throw new IllegalStateException("method 'getAllStudents' needs to be implemented first");

    }

    //public Collection<GouponEvent> getStudentsByRange(int fromStudentId, int toStudentId) {

        // Methode annotieren und ausimplementieren und folgende "throw"-Anweisung löschen!
      //  throw new IllegalStateException("method 'getStudentsByRange' needs to be implemented first");

   // }
}
