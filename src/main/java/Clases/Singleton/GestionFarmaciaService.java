package Clases.Singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public final class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;
    @Getter @Setter private Map<String, Integer> stockMedicamentos = new HashMap<>();
    @Getter @Setter private int pedidosPendientes;
    private GestionFarmaciaService() {}
    public static GestionFarmaciaService getInstance() {
        if (instancia == null) {
            instancia = new GestionFarmaciaService();
        }
        return instancia;
    }
    public boolean verificarStock(Map<Integer, String> medicamentos) {
        for (Map.Entry<Integer, String> entry : medicamentos.entrySet()) {
            String medicamento = entry.getValue();
            if (stockMedicamentos.containsKey(medicamento)) {
                int stock = stockMedicamentos.get(medicamento);
                stock--;
                if (stock >= 0) {
                    return true;
                } else {
                    stockMedicamentos.put(medicamento, stock);
                    return realizarPedido(medicamento, stock);
                }
            }
        }
        return false;
    }

    private boolean realizarPedido(String medicamento, int stockFaltante) {
        int stockActual = stockMedicamentos.getOrDefault(medicamento, 0);
        stockMedicamentos.put(medicamento, stockActual + stockFaltante);
        return true;
    }

    public boolean comprobarStock(Map<Integer, String> medicamentos) {
        for (Map.Entry<Integer, String> entry : medicamentos.entrySet()) {
            String medicamento = entry.getValue();
            if (stockMedicamentos.containsKey(medicamento)) {
                int stock = stockMedicamentos.get(medicamento);
                stock--;
                if (stock >= 0) {
                    return true;
                } else {
                    stockMedicamentos.put(medicamento, stock);
                    return realizarPedido(medicamento, -stock); // Agregar el stock faltante al medicamento
                }
            }
        }
        return false;
    }

}
