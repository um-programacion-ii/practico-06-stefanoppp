package Clases;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Medico {
    private int id;
    private String nombre;
    private String especialidad;
    public boolean consultasParticulares;
    public boolean obraSocial;
    private List<Paciente> pacientes;

    public Medico(int id, String nombre, String especialidad, boolean consultasParticulares, boolean obraSocial) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultasParticulares = consultasParticulares;
        this.obraSocial = obraSocial;
        this.pacientes = new ArrayList<>();
    }
    //Hacer receta
    public void asignarMedicamentos(Paciente paciente, String medicamento, int cantidad) {
        paciente.getMedicamentos().put(cantidad, medicamento);
    }
}

