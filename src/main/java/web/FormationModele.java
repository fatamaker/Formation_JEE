package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Formation;

public class FormationModele {
    private String motCle;
    List<Formation> formations = new ArrayList<>();
    
    public String getMotCle() {
        return motCle;
    }
    
    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }
    
    public List<Formation> getFormations() {
        return formations;
    }
    
    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }
}
