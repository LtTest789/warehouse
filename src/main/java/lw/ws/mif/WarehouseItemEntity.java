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

    @Column(name = "warehouse_address")
    private String warehouseAddress;

    @Column(name = "quantity")
    private int quantity;

    public WarehouseItemEntity() {
    }

    public WarehouseItemEntity(String itemName, String warehouseAddress, int quantity) {
        this.itemName = itemName;
        this.warehouseAddress = warehouseAddress;
        this.quantity = quantity;
    }

    public WarehouseItemEntity(WarehouseItemEntity item) {
        this.itemName = item.getItemName();
        this.warehouseAddress = item.getWarehouseAddress();
        this.quantity = item.getQuantity();
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

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
