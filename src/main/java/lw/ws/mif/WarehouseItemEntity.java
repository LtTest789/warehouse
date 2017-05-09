package lw.ws.mif;

import javax.persistence.*;

/**
 * Created by Romas on 5/2/2017.
 */
@Entity
@Table(name = "warehouse")
public class WarehouseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "warehouse_city")
    private String city;

    @Column(name = "warehouse_street")
    private String street;

    @Column(name = "warehouse_number")
    private String number;

    @Column(name = "quantity")
    private int quantity;

    public WarehouseItemEntity() {
    }

    public WarehouseItemEntity(String itemName, String city, String street, String number, int quantity) {
        this.itemName = itemName;
        this.city = city;
        this.street = street;
        this.number = number;
        this.quantity = quantity;
    }

    public WarehouseItemEntity(WarehouseItemEntity item) {
        this.itemName = item.itemName;
        this.city = item.city;
        this.street = item.street;
        this.number = item.number;
        this.quantity = item.quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
