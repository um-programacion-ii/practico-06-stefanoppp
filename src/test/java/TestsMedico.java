import Clases.DAO.MedicoDAO;
import Clases.Medico;
import Clases.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestsMedico {
    private MedicoDAO medicoDAO;

    @BeforeEach
    public void setUp() {
        medicoDAO = new MedicoDAO();
    }

    @Test
    public void testObtenerTodosLosMedicos() {
        List<Medico> medicos = medicoDAO.obtenerTodosLosMedicos();
        assertEquals(3, medicos.size());
    }

    @Test
    public void testObtenerMedicoPorIdExistente() {
        Medico medico = medicoDAO.obtenerMedicoPorId(1);
        assertNotNull(medico);
        assertEquals(1, medico.getId());
        assertEquals("Dr. Pérez", medico.getNombre());
    }

    @Test
    public void testObtenerMedicoPorIdNoExistente() {
        Medico medico = medicoDAO.obtenerMedicoPorId(100);
        assertNull(medico);
    }

    @Test
    public void testAgregarMedicoDAO() {
        Medico nuevoMedico = new Medico(4, "Dr. Martínez", "Neurología", true, false);
        medicoDAO.agregarMedico(nuevoMedico);
        assertEquals(4, medicoDAO.obtenerTodosLosMedicos().size());
        assertEquals(nuevoMedico, medicoDAO.obtenerMedicoPorId(4));
    }
    @Test
    public void testAsignarMedicamentos() {
        Paciente paciente = new Paciente("Nombre Paciente", "Obra Social", 1);
        Medico medico = new Medico(1, "Dr. Juan", "Cardiología", false, true);
        int key=10;
        String value="Aspirina";
        medico.asignarMedicamentos(paciente, value, key);
        //Primero testeamos que agregue
        assertNotNull(paciente.getMedicamentos());
        //Luego que exista dicho par de clave-valor
        assertTrue(paciente.getMedicamentos().containsKey(10));
        assertEquals("Aspirina", paciente.getMedicamentos().get(10));

    }
}
