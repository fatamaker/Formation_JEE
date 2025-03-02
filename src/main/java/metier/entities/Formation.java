package metier.entities;
import java.io.Serializable;

public class Formation implements Serializable {
   
	private Long idFormation;
    private String nomFormation;
    private double prixFormation;
    private String modeFormation;

    public Formation() {
        super();
    }

    public Formation(String nomFormation, double prixFormation, String modeFormation) {
        super();
        this.nomFormation = nomFormation;
        this.prixFormation = prixFormation;
        this.modeFormation=modeFormation;
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
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", prixFormation="
				+ prixFormation + ", modeFormation=" + modeFormation + "]";
	}


	
    
}
