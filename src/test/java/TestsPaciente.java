import Clases.Singleton.GestionTurnoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestsPaciente {
    @Test
    public void testGenerarTurnoWithValidMedicoAndObraSocial() {
        GestionTurnoService gestionTurnoService = GestionTurnoService.getInstance();
        boolean resultado = gestionTurnoService.generarTurno(1, 1, "ObraSocial");
        assertTrue(resultado, "Se esperaba que se pudiera generar el turno.");
    }
    @Test
    public void testGenerarTurno_WithValidMedicoAndConsultaParticular() {
        GestionTurnoService gestionTurnoService = GestionTurnoService.getInstance();
        boolean resultado = gestionTurnoService.generarTurno(1, 1, null);
        assertTrue(resultado, "Se esperaba que se pudiera generar el turno.");
    }
    @Test
    public void testGenerarTurno_WithInvalidMedico() {
        GestionTurnoService gestionTurnoService = GestionTurnoService.getInstance();
        boolean resultado = gestionTurnoService.generarTurno(1, 100, "ObraSocial");
        assertFalse(resultado, "Se esperaba que no se pudiera generar el turno.");
    }
}
