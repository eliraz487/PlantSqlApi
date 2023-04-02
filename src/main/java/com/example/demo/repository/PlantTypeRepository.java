import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantTypeRepository extends JpaRepository<PlantType, Long>, JpaSpecificationExecutor<PlantType> {

}