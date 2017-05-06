package lw.ws.mif;

import sun.rmi.runtime.Log;

import java.io.Serializable;

/**
 * Created by Romas on 5/2/2017.
 */
public class WarehouseItemForm implements Serializable {

    private Long id;
    private String itemName;
    private String warehouseAddress;
    private int quantity;

    public WarehouseItemForm() {
    }

    public WarehouseItemForm(Long id, String itemName, String warehouseAddress, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.warehouseAddress = warehouseAddress;
        this.quantity = quantity;
    }

    public WarehouseItemForm(WarehouseItemEntity entity) {
        this.id = entity.getId();
        this.itemName = entity.getItemName();
        this.warehouseAddress = entity.getWarehouseAddress();
        this.quantity = entity.getQuantity();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WarehouseItemForm{" +
                "itemName='" + itemName + '\'' +
                ", warehouseAddress='" + warehouseAddress + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
