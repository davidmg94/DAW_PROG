package consultorio_medico;

/**
 *
 * @author David
 */
public class Paciente {

    private String codigoPac;
    private String nombrePac;
    private String apellidoPac;

    public Paciente(String codigoPac, String nombrePac, String apellidoPac) {
        this.codigoPac = codigoPac;
        this.nombrePac = nombrePac;
        this.apellidoPac = apellidoPac;
    }

    public String getApellidoPac() {
        return apellidoPac;
    }

    public void setApellidoPac(String apellidoPac) {
        this.apellidoPac = apellidoPac;
    }

    public String getCodigoPac() {
        return codigoPac;
    }

    public void setCodigoPac(String codigoPac) {
        this.codigoPac = codigoPac;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    @Override
    public String toString() {
        return "Visitas{" + "codigo=" + codigoPac + ", nombre=" + nombrePac + ", apellido=" + apellidoPac + '}';
    }
}
