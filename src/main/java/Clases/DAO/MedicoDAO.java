package Clases.DAO;
import Clases.Medico;
import java.util.ArrayList;
import java.util.List;
public class MedicoDAO{
    public List<Medico> medicos;
    public MedicoDAO() {
        this.medicos = new ArrayList<>();
        cargarMedicosDAO();
    }
    private void cargarMedicosDAO() {
        medicos.add(new Medico(1, "Dr. Pérez", "Pediatría", true, true));
        medicos.add(new Medico(2, "Dra. Gómez", "Cardiología",true, false ));
        medicos.add(new Medico(3, "Dr. López", "Dermatología", false, true));
    }
    public List<Medico> obtenerTodosLosMedicos() {
        return medicos;
    }
    public Medico obtenerMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }
    public boolean obraSocialPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico.obraSocial;
            }
        }
        return false;
    }
    public boolean consultasParticularesPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico.consultasParticulares;
            }
        }
        return false;
    }
    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

}