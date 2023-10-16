package consultorio_medico;


/**
 *
 * @author David
 */
public class Visitas {

    private String codVisita;
    private String fecha_Visita;
    private Paciente paciente;
    private Medico medico;
    private int tipoVisita;
    private String descripcion;
    private String tratamiento;
    private double precio;
    public static final int CONSULTA = 0;
    public static final int REVISION = 1;
    public static final int RECETAS = 2;
    public static final int URGENCIAS = 3;
    public static final double PRECIO_MINIMO = 50;


    private static int numRevisiones;
    private static int numRecetas;
    private static int numConsultas;
    private static int numUrgencias;

    public Visitas(String codVisita, String fecha_Visita, Paciente paciente, Medico medico, int tipoVisita, String descripcion, String tratamiento, double precio) {
        this.codVisita = codVisita;
        this.fecha_Visita = fecha_Visita;
        this.paciente = paciente;
        this.medico = medico;
        this.tipoVisita = tipoVisita;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(String codVisita) {
        this.codVisita = codVisita;
    }

    public String getFecha_Visita() {
        return fecha_Visita;
    }

    public void setFecha_Visita(String fecha_Visita) {
        this.fecha_Visita = fecha_Visita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(int tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public static int getNumRevisiones() {
        return numRevisiones;
    }

    public static void setNumRevisiones(int aNumRevisiones) {
        numRevisiones = aNumRevisiones;
    }

    public static int getNumRecetas() {
        return numRecetas;
    }

    public static void setNumRecetas(int aNumRecetas) {
        numRecetas = aNumRecetas;
    }

    public static int getNumConsultas() {
        return numConsultas;
    }

    public static void setNumConsultas(int aNumConsultas) {
        numConsultas = aNumConsultas;
    }

    public static int getNumUrgencias() {
        return numUrgencias;
    }

    public static void setNumUrgencias(int aNumUrgencias) {
        numUrgencias = aNumUrgencias;
    }

    @Override
    public String toString() {
        return "Visita: " + codVisita + "\nPaciente: " + paciente.getCodigoPac() + " " + paciente.getNombrePac()
                + "\nTipo de Visita: " + tipoVisita + "\nFecha: " + fecha_Visita + "\nMédico :" + medico.getNombreMed() + "\nPrecio :" + precio;
    }
//    Crea un método estático que devuelva el número de Visitas asociado a un tipo de visita
//devuelveNumVisita(tipo).Si el tipo que se le pasa como parámetro es CONSULTAS
//devolverá el valor del atributo numConsultas, si es REVISION devolverá el valor de numRevisiones, 
//        si el valor que se le pasa es RECETAS devolverá el valor de numRecetas 
//        y si el valor es URGENCIAS devolverá el valor de numUrgencias

    public static int devuelveNumVisita(int tipoVisita) {
        int numVisita = 0;
        switch (tipoVisita) {
            case 0:
                numVisita = numConsultas;
                break;
            case 1:
                numVisita = numRevisiones;
                break;
            case 2:
                numVisita = numRecetas;
                break;
            case 3:
                numVisita = numUrgencias;
                break;
            default:
                throw new AssertionError("No existe el tipo de visita indicado");
        }
        return numVisita;
    }
//    ALTERNATIVA
//    public static int devuelveNumVisita(int tipoVisita) {
//        switch (tipoVisita) {
//            case 0:
//                 return Visita.numConsultas;
//            case 1:
//                 return Visita.numRevisiones;
//            case 2:
//                 return Visita.numRecetas;
//            case 3:
//                 return Visita.numUrgencias;
//            default:
//                throw new AssertionError("No existe el tipo de visita indicado");
//        }
//    }

    public static int incrementarVisita(int tipoVisita) {
        int numVisita = 0;
        switch (tipoVisita) {
            case 0:
                numVisita = numConsultas++;
                break;
            case 1:
                numVisita = numRevisiones++;
                break;
            case 2:
                numVisita = numRecetas++;
                break;
            case 3:
                numVisita = numUrgencias++;
                break;
            default:
                throw new AssertionError("No existe el tipo de visita indicado");
        }
        return numVisita;
    }

//    ALTERNATIVA
//    public static int incrementarVisita(int tipoVisita) {
//        switch (tipoVisita) {
//            case 0:
//                Visita.numConsultas++;
//            case 1:
//                Visita.numRevisiones++;
//            case 2:
//                Visita.numRecetas++;
//            case 3:
//                Visita.numUrgencias++;
//            default:
//                throw new AssertionError("No existe el tipo de visita indicado");
//        }
//    }
    public static void reinicializarVisita() {
        setNumConsultas(0);
        setNumRecetas(0);
        setNumRevisiones(0);
        setNumUrgencias(0);
    }

//    ALTERNATIVA
//    public static void reinicializarVisita() {
//        Visita.numConsultas = 0;
//        Visita.numRevisiones = 0;
//        Visita.numRecetas = 0;
//        Visita.numUrgencias = 0;
//    }
}
