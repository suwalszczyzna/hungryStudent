package pl.dsuwala.hungrystudent.viewmodels;

public class FridgeItemViewModel {
    public Long id;
    public String name;
    public double amount;
    public String unitShortName;

    public FridgeItemViewModel() {
    }

    public FridgeItemViewModel(String name, double amount, String unitShortName) {
        this.name = name;
        this.amount = amount;
        this.unitShortName = unitShortName;
    }

    public FridgeItemViewModel(Long id, String name, double amount, String unitShortName) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unitShortName = unitShortName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnitShortName() {
        return unitShortName;
    }

    public void setUnitShortName(String unitShortName) {
        this.unitShortName = unitShortName;
    }
}
