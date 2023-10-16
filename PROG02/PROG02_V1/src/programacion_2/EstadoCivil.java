package programacion_2;

public enum EstadoCivil {
    S("Soltero"), C("Casado"), V("Viudo"), D("Divorciado");
    
    private final String estado_civil;

    private EstadoCivil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    String getEstadoCivil() {
        return this.estado_civil;
    }
}
