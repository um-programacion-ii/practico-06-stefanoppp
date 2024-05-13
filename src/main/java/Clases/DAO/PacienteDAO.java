package Clases.DAO;
import Clases.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private List<Paciente> pacientes;

    public PacienteDAO() {
        this.pacientes = new ArrayList<>();
        cargarPacientesDeEjemplo();
    }
    private void cargarPacientesDeEjemplo() {
        pacientes.add(new Paciente("Juan Perez", "Damsu", 25));
        pacientes.add(new Paciente("Armando Gonzalez", "Damsu", 30));
        pacientes.add(new Paciente("Sofia Ponce", "Osep",  40));
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacientes;
    }

    public Paciente obtenerPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}