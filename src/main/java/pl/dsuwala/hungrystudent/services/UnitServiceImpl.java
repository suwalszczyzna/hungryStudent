package pl.dsuwala.hungrystudent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.repo.UnitRepository;

import javax.management.RuntimeOperationsException;
import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService{

    private UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public void saveUnit(Unit unit) {
        this.unitRepository.save(unit);
    }

    @Override
    public Unit getUnitById(Long id) {
        Optional<Unit> optionalUnit = unitRepository.findById(id);
        Unit unit = null;

        if(optionalUnit.isPresent()){
            unit = optionalUnit.get();
        }else{
            throw new RuntimeException("Nie znaleziono jednostki o id: " + id);
        }
        return unit;

    }

    @Override
    public void deleteUnitById(Long id) {
        Optional<Unit> optionalUnit = unitRepository.findById(id);

        if(optionalUnit.isPresent()){
            unitRepository.deleteById(id);
        }else{
            throw new RuntimeException("Nie znaleziono jednostki o id: " + id);
        }
    }
}
