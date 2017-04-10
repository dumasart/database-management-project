/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccessLayer.ConnectionSQL;
import Model.DataTransfertObject.ExpertDAO;
import Model.DataTransfertObject.ExpertDAOSQL;
import Model.DataTransfertObject.NumeroDAO;
import Model.DataTransfertObject.NumeroDAOSQL;
import Model.DataTransfertObject.SpectacleDAO;
import Model.Numero;
import Model.DataTransfertObject.SpectacleDAOSQL;
import Model.Expert;
import Model.Spectacle;
import java.util.List;

/**
 *
 * @author nomezing
 */
public class GesProgrammeController extends MainController {

    private SpectacleDAO spectacleDAO = new SpectacleDAOSQL();
    private NumeroDAO numeroDAO = new NumeroDAOSQL();
    private ExpertDAO expertDAO = new ExpertDAOSQL();

    public List<Spectacle> getAllSpectacles() {
        return spectacleDAO.getAllSpectacle();
    }

    public List<Numero> getNumerosBySpectacle(Spectacle spectacle) {
        return numeroDAO.getNumerosBySpectacle(spectacle);
    }

    public List<Expert> getExpertsNePasEvaluerNumero(int id) {
        return expertDAO.getExpertsWithoutEvaluationOnNumero(id);
    }

    public List<Numero> getNumerosAEvaluer() {
        return numeroDAO.getNumerosWithoutFiveEvaluations();
    }
}
