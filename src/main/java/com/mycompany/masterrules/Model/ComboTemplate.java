package com.mycompany.masterrules.Model;

import java.util.HashMap;


public class ComboTemplate {
    private HashMap<String, Integer> comboRequirements;

    public void setComboRequirements(HashMap<String, Integer> comboRequirements) {
        this.comboRequirements = comboRequirements;
    }

    public HashMap<String, Integer> getComboRequirements() {
        return comboRequirements;
    }

    // implementar el metodo para verificar si el combo es valido
    public boolean verifyCombo(Order order) {      
    }
}
