package Enum;

public enum nombre {
    S("Soltero"), C("Casado"), V("Viudo"), D("Divorciado");

    private final String estado_civil;

    private nombre(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    String getEstadoCivil() {
        return this.estado_civil;
    }
}
