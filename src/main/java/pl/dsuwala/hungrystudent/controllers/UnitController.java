package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.services.UnitService;

@Controller
public class UnitController {

    private UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/units")
    public String showAllUnits(Model model){
        model.addAttribute("units", unitService.getAllUnits());
        return "pages/units/all_units";
    }

    @GetMapping("/units/add")
    public String newUnitForm(Model model){
        Unit unit = new Unit();
        model.addAttribute("unit", unit);
        return "pages/units/add_new_unit";
    }

    @PostMapping("/units/save")
    public String saveUnit(@ModelAttribute Unit unit){
        unitService.saveUnit(unit);
        return "redirect:/units";
    }

    @GetMapping("/units/showUpdate/{id}")
    public String updateUnitForm(@PathVariable(value = "id") long id, Model model){
        Unit unit = unitService.getUnitById(id);
        model.addAttribute("unit", unit);
        return "/pages/units/update";
    }

    @GetMapping("/units/deleteUnit/{id}")
    public String deleteUnit(@PathVariable(value = "id") long id){
        unitService.deleteUnitById(id);
        return "redirect:/units";
    }

}
