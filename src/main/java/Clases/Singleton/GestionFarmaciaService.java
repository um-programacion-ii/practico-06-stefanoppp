package Clases.Singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;

    // Atributos privados
    @Getter @Setter private Map<String, Integer> stockMedicamentos = new HashMap<>();
    @Getter @Setter private int pedidosPendientes;

    private GestionFarmaciaService() {

    }

    public static GestionFarmaciaService getInstance() {
        if (instancia == null) {
            instancia = new GestionFarmaciaService();
        }
        return instancia;
    }

    public int verificarStock(String medicamento) {
        return stockMedicamentos.getOrDefault(medicamento, 0);
    }

    public void realizarPedido(String medicamento, int cantidad) {

        pedidosPendientes++;

    }
}
