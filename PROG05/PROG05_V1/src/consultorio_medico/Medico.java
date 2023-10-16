package consultorio_medico;

import prog05_tarea.enumEspecialidad;

/**
 *
 * @author David
 */
public class Medico {

    private String codigoMed;
    private String dniMed;
    private String nombreMed;
    private enumEspecialidad especialidad;

    public Medico() {
    }

    public Medico(String Med, String dniMed, String nombreMed, enumEspecialidad especialidad) {
        this.codigoMed = Med;
        this.dniMed = dniMed;
        this.nombreMed = nombreMed;
        this.especialidad = especialidad;
    }

    public String getCodigoMed() {
        return codigoMed;
    }

    public void setCodigoMed(String codigoMed) {
        this.codigoMed = codigoMed;
    }

    public String getDniMed() {
        return dniMed;
    }

    public void setDniMed(String dniMed) {
        this.dniMed = dniMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public enumEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(enumEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" + "codigo=" + codigoMed + ", dni=" + dniMed + ", nombre=" + nombreMed + ", especialidad=" + especialidad + '}';
    }
}
