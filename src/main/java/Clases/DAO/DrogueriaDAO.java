package Clases.DAO;
import java.util.ArrayList;
import java.util.List;

public class DrogueriaDAO {
    private List<String> stock;

    public DrogueriaDAO() {
        this.stock = new ArrayList<>();
    }

    public List<String> obtenerStock() {
        return stock;
    }

    public void agregarMedicamento(String medicamento) {
        stock.add(medicamento);
    }

    public void enviarMedicamentos(String medicamento) {
        // Implementación de enviar medicamentos
    }
}

