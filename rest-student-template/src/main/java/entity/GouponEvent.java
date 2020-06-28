package entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GouponEvent {
    @XmlAttribute
    private int eventId;
    private String name;
    private String description;
    private String date;
    private String pickupAddress;

    // Default-Konstruktor zwingend notwendig
    public GouponEvent() {}

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }




}
