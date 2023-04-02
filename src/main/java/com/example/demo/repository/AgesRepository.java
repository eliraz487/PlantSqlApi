import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgesRepository extends JpaRepository<Ages, Long>, JpaSpecificationExecutor<Ages> {

}