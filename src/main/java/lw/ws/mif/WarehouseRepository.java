package lw.ws.mif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Romas on 5/2/2017.
 */
@Repository
public interface WarehouseRepository extends JpaRepository <WarehouseItemEntity, Long>{
}
