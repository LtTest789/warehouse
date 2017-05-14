package lw.ws.mif;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Romas on 5/2/2017.
 */
public class WarehouseItemForm implements Serializable {

    private Long id;
    private String city;
    private String street;
    private String number;
    private List<ItemForm> itemFormList;

    public WarehouseItemForm() {
    }

    public WarehouseItemForm( String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public WarehouseItemForm(WarehouseItemEntity entity) {
        this.id = entity.getId();
        this.city = entity.getCity();
        this.street = entity.getStreet();
        this.number = entity.getNumber();
        this.itemFormList = entity.getItemForms();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public List<ItemForm> getItemFormList() {
        return itemFormList;
    }

    public void setItemFormList(List<ItemForm> itemFormList) {
        this.itemFormList = itemFormList;
    }

    @Override
    public String toString() {
        return "WarehouseItemForm{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
