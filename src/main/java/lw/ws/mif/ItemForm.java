package lw.ws.mif;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Romas on 5/14/2017.
 */
@Entity
@Table(name = "warehouse_item")
public class ItemForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "country_of_manufacturing")
    private String countryOfManufactor;
    @Column(name = "date_of_manufacturing")
    private String dateOfManufactor;
    @Column(name = "warehouse_id")
    private Long warehouseId;

    public ItemForm() {
    }

    public ItemForm(Long id,  Long itemId, String itemName, String description, String countryOfManufactor, String dateOfManufactor) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        if(description == null) {
            this.description = "not specified";
        } else {
            this.description = description;
        }
        if(countryOfManufactor == null) {
            this.countryOfManufactor = "not specified";
        } else {
            this.countryOfManufactor = countryOfManufactor;
        }
        this.dateOfManufactor = dateOfManufactor;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryOfManufactor() {
        return countryOfManufactor;
    }

    public void setCountryOfManufactor(String countryOfManufactor) {
        this.countryOfManufactor = countryOfManufactor;
    }

    public String getDateOfManufactor() {
        return dateOfManufactor;
    }

    public void setDateOfManufactor(String dateOfManufactor) {
        this.dateOfManufactor = dateOfManufactor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "ItemForm{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", countryOfManufactor='" + countryOfManufactor + '\'' +
                ", dateOfManufactor='" + dateOfManufactor + '\'' +
                '}';
    }
}
