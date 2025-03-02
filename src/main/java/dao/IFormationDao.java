package dao;
import java.util.List;
import metier.entities.Formation;

public interface IFormationDao {
    public Formation save(Formation f);
    public List<Formation> formationsParMC(String mc);
    public Formation getFormation(Long id);
    public Formation updateFormation(Formation f);
    public void deleteFormation(Long id);
}
