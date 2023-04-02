import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgePlantTypeRepository extends JpaRepository<AgePlantType, Void>, JpaSpecificationExecutor<AgePlantType> {

}