package lw.ws.mif;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Romas on 5/2/2017.
 */
@Entity
@Table(name = "warehouse")
public class WarehouseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "warehouse_city")
    private String city;

    @Column(name = "warehouse_street")
    private String street;

    @Column(name = "warehouse_number")
    private String number;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "warehouse_id")
    private List<ItemForm> itemForms;

    public WarehouseItemEntity() {
    }

    public WarehouseItemEntity(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public WarehouseItemEntity(WarehouseItemEntity item) {
        this.city = item.city;
        this.street = item.street;
        this.number = item.number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<ItemForm> getItemForms() {
        return itemForms;
    }

    public void setItemForms(List<ItemForm> itemForms) {
        this.itemForms = itemForms;
    }
}
