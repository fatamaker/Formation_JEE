package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IFormationDao;
import dao.FormationDaoImpl;
import metier.entities.Formation;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.go", "*.do" })
public class ControleurServlet extends HttpServlet {

    IFormationDao metier;

    @Override
    public void init() throws ServletException {
        metier = new FormationDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("formations.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            FormationModele model = new FormationModele();
            model.setMotCle(motCle);
            List<Formation> formations = metier.formationsParMC(motCle);
            model.setFormations(formations);
            request.setAttribute("model", model);
            request.getRequestDispatcher("formations.jsp").forward(request, response);
        
        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieFormation.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nomFormation = request.getParameter("nomFormation");
            double prixFormation = Double.parseDouble(request.getParameter("prixFormation"));
            String modeFormation = request.getParameter("modeFormation");
            Formation f = metier.save(new Formation(nomFormation, prixFormation, modeFormation));
            request.setAttribute("formation", f);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteFormation(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Formation f = metier.getFormation(id);
            request.setAttribute("formation", f);
            request.getRequestDispatcher("editerFormation.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nomFormation = request.getParameter("nomFormation");
            double prixFormation = Double.parseDouble(request.getParameter("prixFormation"));
            String modeFormation = request.getParameter("modeFormation");
            Formation f = new Formation();
            f.setIdFormation(id);
            f.setNomFormation(nomFormation);
            f.setPrixFormation(prixFormation);
            f.setModeFormation(modeFormation);
            metier.updateFormation(f);
            request.setAttribute("formation", f);
            response.sendRedirect("chercher.do?motCle=");
        } else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}