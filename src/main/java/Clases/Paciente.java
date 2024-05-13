package Clases;
import Clases.Singleton.AtencionMedicoService;
import Clases.DAO.*;
import Clases.Singleton.GestionTurnoService;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Setter
@Getter

public class Paciente {
    private String nombre;
    private String obraSocial;
    private int id;
    private Map<Integer, String> medicamentos;

    public Paciente(String nombre, String obraSocial, int id) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
        this.id = id;
        this.medicamentos = new HashMap<>();
    }
    public List<Medico> solicitarMedicos() {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.obtenerTodosLosMedicos();
    }
    public Set<String> verEspecialidades() {
        AtencionMedicoService servicioMedico = AtencionMedicoService.getInstance();
        return servicioMedico.verEspecialidades();
    }
    public boolean resevarTurno() {
        GestionTurnoService turnoService = GestionTurnoService.getInstance();
        return turnoService.generarTurno(this.id, 1, this.obraSocial);
    }
}
