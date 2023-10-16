package programacion_2;

public enum SexoPaciente {
    H("Hombre"), M("Mujer");
    private final String sexo;

    private SexoPaciente(String tipo_sexo) {
        this.sexo = tipo_sexo;
    }

    String getSexo() {
        return this.sexo;
    }
}
