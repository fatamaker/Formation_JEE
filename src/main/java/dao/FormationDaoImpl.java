package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Formation;

public class FormationDaoImpl implements IFormationDao {
	
	@Override
	public Formation save(Formation f) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO FORMATION(NOM_FORMATION, PRIX_FORMATION, MODE_FORMATION) VALUES(?, ?, ?)");
	        ps.setString(1, f.getNomFormation());
	        ps.setDouble(2, f.getPrixFormation());
	        ps.setString(3, f.getModeFormation()); // Set the value for the third parameter
	        ps.executeUpdate();
	        
	        PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_FORMATION) as MAX_ID FROM FORMATION");
	        ResultSet rs = ps2.executeQuery();
	        if (rs.next()) {
	            f.setIdFormation(rs.getLong("MAX_ID"));
	        }
	        ps.close();
	        ps2.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return f;
	}
	@Override
	public List<Formation> formationsParMC(String mc) {
		List<Formation> formations = new ArrayList<Formation>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM FORMATION WHERE NOM_FORMATION LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Formation f = new Formation();
				f.setIdFormation(rs.getLong("ID_FORMATION"));
				f.setNomFormation(rs.getString("NOM_FORMATION"));
				f.setPrixFormation(rs.getDouble("PRIX_FORMATION"));
				f.setModeFormation(rs.getString("MODE_FORMATION"));
				formations.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formations;
	}

	@Override
	public Formation getFormation(Long id) {
		Connection conn = SingletonConnection.getConnection();
		Formation f = new Formation();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM FORMATION WHERE ID_FORMATION = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f.setIdFormation(rs.getLong("ID_FORMATION"));
				f.setNomFormation(rs.getString("NOM_FORMATION"));
				f.setPrixFormation(rs.getDouble("PRIX_FORMATION"));
				f.setModeFormation(rs.getString("MODE_FORMATION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public Formation updateFormation(Formation f) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("UPDATE FORMATION SET NOM_FORMATION=?, PRIX_FORMATION=?, MODE_FORMATION=? WHERE ID_FORMATION=?");
	        ps.setString(1, f.getNomFormation());
	        ps.setDouble(2, f.getPrixFormation());
	        ps.setString(3, f.getModeFormation()); 
	        ps.setLong(4, f.getIdFormation());
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return f;
	}

	@Override
	public void deleteFormation(Long id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM FORMATION WHERE ID_FORMATION = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
