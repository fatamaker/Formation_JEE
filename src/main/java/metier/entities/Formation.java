package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORMATION")
public class Formation implements Serializable {
    
    @Id
    @Column(name = "IDFORMATION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;

    @Column(name = "NOMFORMATION")
    private String nomFormation;

    @Column(name = "PRIXFORMATION")
    private double prixFormation;

    @Column(name = "MODEFORMATION")
    private String modeFormation;

    public Formation() {
        super();
    }

    public Formation(String nomFormation, double prixFormation, String modeFormation) {
        super();
        this.nomFormation = nomFormation;
        this.prixFormation = prixFormation;
        this.modeFormation = modeFormation;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public double getPrixFormation() {
        return prixFormation;
    }

    public void setPrixFormation(double prixFormation) {
        this.prixFormation = prixFormation;
    }

    public String getModeFormation() {
        return modeFormation;
    }

    public void setModeFormation(String modeFormation) {
        this.modeFormation = modeFormation;
    }

    @Override
    public String toString() {
        return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation 
                + ", prixFormation=" + prixFormation + ", modeFormation=" + modeFormation + "]";
    }
}
