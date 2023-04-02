import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantGrowEnvironmentRepository extends JpaRepository<PlantGrowEnvironment, Long>, JpaSpecificationExecutor<PlantGrowEnvironment> {

}