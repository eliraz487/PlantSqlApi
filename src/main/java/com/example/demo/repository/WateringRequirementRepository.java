import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WateringRequirementRepository extends JpaRepository<WateringRequirement, Long>, JpaSpecificationExecutor<WateringRequirement> {

}