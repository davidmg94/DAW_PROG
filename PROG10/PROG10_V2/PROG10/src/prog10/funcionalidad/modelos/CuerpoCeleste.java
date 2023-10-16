package prog10.funcionalidad.modelos;

import static prog10.entornografico.EntornoGrafico.*;
import prog10.funcionalidad.excepciones.ExcepcionCuerpoCeleste;
import java.io.Serializable;
import javax.swing.JOptionPane;

public final class CuerpoCeleste implements Serializable {

    private int codigoCuerpo;
    private String nombre;
    private String tipoCuerpo;
    private int diametro;

    public CuerpoCeleste() {
        this.codigoCuerpo = 0;
        this.diametro = 0;
        this.nombre = "S/N";
        this.tipoCuerpo = "S/C";
    }

    public CuerpoCeleste(int codigoCuerpo, String nombre, String tipoCuerpo, int diametro) {
        try {
            exCuerpoCeleste(codigoCuerpo, nombre, tipoCuerpo, diametro);
            this.codigoCuerpo = codigoCuerpo;
            this.nombre = nombre;
            this.tipoCuerpo = tipoCuerpo;
            this.diametro = diametro;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        try {
            exCuerpoCeleste(codigoCuerpo, nombre, tipoCuerpo, diametro);
            this.diametro = diametro;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCodigoCuerpo() {
        return codigoCuerpo;
    }

    public void setCodigoCuerpo(int codigoCuerpo) {
        try {
            exCuerpoCeleste(codigoCuerpo, nombre, tipoCuerpo, diametro);
            this.codigoCuerpo = codigoCuerpo;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try {
            exCuerpoCeleste(codigoCuerpo, nombre, tipoCuerpo, diametro);
            this.nombre = nombre;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
    }

    public String getTipoCuerpo() {
        return tipoCuerpo;
    }

    public void setTipoCuerpo(String tipoCuerpo) {
        try {
            exCuerpoCeleste(codigoCuerpo, nombre, tipoCuerpo, diametro);
            this.tipoCuerpo = tipoCuerpo;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "CuerpoCeleste: codigoCuerpo=" + codigoCuerpo + ", nombre=" + nombre + ", tipoCuerpo=" + tipoCuerpo + ", diametro=" + diametro;
    }

    private void exCuerpoCeleste(int codigoCuerpo, String nombre, String tipoCuerpo, int diametro) throws ExcepcionCuerpoCeleste {
        if (Integer.toString(codigoCuerpo).length() > 3) {
            JOptionPane.showMessageDialog(txtCodigo, "¡ERROR! El código debe ser un número entero de 3 dígitos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (nombre.length() > 15) {
            JOptionPane.showMessageDialog(txtCodigo, "¡ERROR! El nombre no debe exceder los 15 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!"luna".equalsIgnoreCase(tipoCuerpo) && !"planeta enano".equalsIgnoreCase(tipoCuerpo) && !"planeta".equalsIgnoreCase(tipoCuerpo)) {
            JOptionPane.showMessageDialog(txtCodigo, "¡ERROR! Debe introducir tipos correctos ('luna', 'planeta enano', 'planeta').", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (Integer.toString(diametro).length() > 6) {
            JOptionPane.showMessageDialog(txtCodigo, "¡ERROR! El diámetro debe ser un número entero de 6 dígitos como máximo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
