package Clases.Singleton;

import Clases.DAO.MedicoDAO;
import Clases.Medico;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private final List<String> specializations;

    private GestionTurnoService() {
        specializations = new ArrayList<>();
        specializations.add("Cardiología");
        specializations.add("Neurología");
        specializations.add("Cirugía");
        specializations.add("Pediatría");
        specializations.add("Dermatología");
    }
    public static GestionTurnoService getInstance() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }
    @Getter @Setter private int idPaciente;
    @Getter @Setter private int idMedico;
    @Getter @Setter private boolean consultaParticular;
    public List<String> listarEspecialidades() {
        return specializations;
    }
    public boolean generarTurno(int idPaciente, int idMedico, String obraSocialPaciente) {
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoDAO.obtenerMedicoPorId(idMedico);
        if (medico == null) {
            System.out.println("El médico con ID " + idMedico + " no fue encontrado.");
            return false;
        }

        //Obtenemos id del medico para saber si recibe obra sociales
        boolean obraSocialDelMedico = medicoDAO.obraSocialPorId(idMedico);
        boolean consultaParticular = medicoDAO.consultasParticularesPorId(idMedico);

        if (!obraSocialDelMedico && obraSocialPaciente!=null){
            return false;
        }
        return consultaParticular || obraSocialPaciente != null;
    }
}