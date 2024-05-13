package Clases;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ObraSocial {
    private String nombre;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    public ObraSocial(String nombre) {
        this.nombre = nombre;
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

}
