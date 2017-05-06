package lw.ws.mif;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Romas on 5/2/2017.
 */
public interface WarehouseItemService {
    boolean saveItem(WarehouseItemForm itemForm);
    List<WarehouseItemForm> retrieveAllItems();
    WarehouseItemForm retrieveItem(Long itemId);
    boolean deleteItem(Long itemId);
    boolean updateItem(Long itemId, WarehouseItemForm itemForm);
}
