package lw.ws.mif;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Romas on 5/14/2017.
 */
public interface WarehouseItemRepository extends JpaRepository<ItemForm, Long> {
}
