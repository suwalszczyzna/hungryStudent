package pl.dsuwala.hungrystudent.services;
import pl.dsuwala.hungrystudent.domain.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    void saveUnit(Unit unit);
    Unit getUnitById(Long id);
    void deleteUnitById(Long id);
}
