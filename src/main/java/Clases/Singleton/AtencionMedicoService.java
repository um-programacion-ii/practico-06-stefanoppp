package Clases.Singleton;
import Clases.Medico;
import Clases.DAO.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AtencionMedicoService {
    private static AtencionMedicoService instance;

    @Getter @Setter private List<Medico> listadoMedicos;
    @Getter @Setter private List<String> listadoRecetas;
    @Getter @Setter private Set<String> especialidades;

    private AtencionMedicoService() {
        listadoMedicos = new ArrayList<>();
        listadoRecetas = new ArrayList<>();
        especialidades = new HashSet<>();

        especialidades.add("Pediatría");
        especialidades.add("Cardiología");
        especialidades.add("Dermatología");
        especialidades.add("Oftalmología");
    }

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public List<Medico> verMedicos() {
        return listadoMedicos;
    }
    public Set<String> verEspecialidades() {
        return especialidades;
    }
}
