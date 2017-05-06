package lw.ws.mif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Romas on 5/2/2017.
 */
@Service
public class WarehouseServiceImpl implements  WarehouseItemService{

    private Optional<WarehouseItemEntity> warehouseItemEntity;
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public boolean saveItem(WarehouseItemForm itemForm) {

        WarehouseItemEntity entity = new WarehouseItemEntity();
        entity.setItemName(itemForm.getItemName());
        entity.setQuantity(itemForm.getQuantity());
        entity.setWarehouseAddress(itemForm.getWarehouseAddress());
        try {
            warehouseRepository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<WarehouseItemForm> retrieveAllItems() {
        List<WarehouseItemEntity> itemEntities = warehouseRepository.findAll();
        List<WarehouseItemForm> itemForms = new ArrayList<>();
        for(WarehouseItemEntity entity : itemEntities) {
            itemForms.add(new WarehouseItemForm(entity));
        }
        return itemForms;
    }

    @Override
    public WarehouseItemForm retrieveItem(Long itemId) {
        WarehouseItemEntity item = warehouseRepository.findOne(itemId);
        if(item == null) {
            return new WarehouseItemForm();
        }
        return new WarehouseItemForm(item);
    }

    @Override
    public boolean deleteItem(Long itemId) {
        if (!itemExist(itemId)) {
            return false;
        }
        WarehouseItemEntity deleteItem = warehouseItemEntity.get();
        warehouseRepository.delete(deleteItem);
        return true;
    }

    @Override
    public boolean updateItem(Long itemId, WarehouseItemForm itemForm) {
        if (itemExist(itemId)) {
            WarehouseItemForm updatableForm = checkForNulls(itemForm);
            WarehouseItemEntity updateItem = warehouseItemEntity.get();
            updateItem.setItemName(updatableForm.getItemName());
            updateItem.setQuantity(updatableForm.getQuantity());
            updateItem.setWarehouseAddress(updatableForm.getWarehouseAddress());
            try {
                warehouseRepository.save(updateItem);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean itemExist(Long itemId) {
        warehouseItemEntity = Optional.of(warehouseRepository.findOne(itemId));
        if (warehouseItemEntity.isPresent()) {
            return true;
        }
        return false;
    }

    public WarehouseItemForm checkForNulls(WarehouseItemForm itemForm) {
        if (itemForm.getItemName() == null) {
            itemForm.setItemName(warehouseItemEntity.get().getItemName());
        }
        if (itemForm.getQuantity() > 0) {
            itemForm.setQuantity(warehouseItemEntity.get().getQuantity());
        }
        if (itemForm.getWarehouseAddress() == null) {
            itemForm.setWarehouseAddress(warehouseItemEntity.get().getWarehouseAddress());
        }
        return itemForm;
    }

}
