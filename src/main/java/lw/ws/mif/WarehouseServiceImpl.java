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
    @Autowired
    private WarehouseItemRepository warehouseItemRepository;

    @Override
    public boolean saveItem(WarehouseItemForm itemForm) {

        WarehouseItemEntity entity = new WarehouseItemEntity();
        entity.setCity(itemForm.getCity());
        entity.setStreet(itemForm.getStreet());
        entity.setNumber(itemForm.getNumber());
        try {
            WarehouseItemEntity entityW = warehouseRepository.save(entity);
            for (ItemForm i :itemForm.getItemFormList()) {
                i.setWarehouseId(entityW.getId());
                warehouseItemRepository.save(i);
            }
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
            updateItem.setCity(updatableForm.getCity());
            updateItem.setStreet(updatableForm.getStreet());
            updateItem.setNumber(updatableForm.getNumber());
            updateItem.setItemForms(itemForm.getItemFormList());
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
        if (itemForm.getCity() == null) {
            itemForm.setCity(warehouseItemEntity.get().getCity());
        }
        if (itemForm.getStreet() == null) {
            itemForm.setNumber(warehouseItemEntity.get().getStreet());
        }
        if (itemForm.getNumber() == null) {
            itemForm.setNumber(warehouseItemEntity.get().getNumber());
        }
        return itemForm;
    }

}
