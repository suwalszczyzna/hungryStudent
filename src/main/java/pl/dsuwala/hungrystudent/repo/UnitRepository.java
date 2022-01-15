package pl.dsuwala.hungrystudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dsuwala.hungrystudent.domain.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
