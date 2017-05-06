package lw.ws.mif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static lw.ws.mif.ItemStateInWarehouse.*;

/**
 * Created by Romas on 5/2/2017.
 */
@RestController
@RequestMapping(path = "/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseItemService warehouseItemService;

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public ResponseEntity<ItemStateInWarehouse> addItem(@RequestBody @Valid WarehouseItemForm warehouseItemForm, HttpServletResponse response) {
     warehouseItemService.saveItem(warehouseItemForm);
        if (warehouseItemService.saveItem(warehouseItemForm)) {
            response.setHeader("Item", "/warehouse/items");
            return new ResponseEntity(ItemStateInWarehouse.ITEM_ADDED_TO_WAREHOUSE, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ItemStateInWarehouse.ITEM_WITH_ALREADY_EXIST, HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public ResponseEntity<List<WarehouseItemForm>> getItem() {
        return new ResponseEntity<>(warehouseItemService.retrieveAllItems(), HttpStatus.OK);
    }

        @RequestMapping(path = "/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<WarehouseItemForm> getItemById(@PathVariable("id") Long itemId) {
            WarehouseItemForm retrievedItem = warehouseItemService.retrieveItem(itemId);
            if(retrievedItem.getId() == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(warehouseItemService.retrieveItem(itemId), HttpStatus.FOUND);
    }

        @RequestMapping(path = "/items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ItemStateInWarehouse> deleteItem(@PathVariable("id") Long itemId) {
            if (warehouseItemService.deleteItem(itemId)) {
                return new ResponseEntity<>(ItemStateInWarehouse.ITEM_DELETED_FROM_DATABASE, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(ItemStateInWarehouse.ITEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
    }

        @RequestMapping(path = "/items/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ItemStateInWarehouse> updateItem(@PathVariable("id") Long itemId, WarehouseItemForm itemForm,HttpServletResponse response) {
            if (warehouseItemService.updateItem(itemId, itemForm)) {
                response.setHeader("Item", "/shop/items");
                return new ResponseEntity<>(ItemStateInWarehouse.ITEM_UPDATED, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(ItemStateInWarehouse.ITEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
    }
}
