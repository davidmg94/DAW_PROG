package modelo;

//import excepciones.ExcepcionTipoObjeto;
//import excepciones.ExcepcionNombre;
//import excepciones.ExcepcionDiametro;
//import excepciones.ExcepcionCodigoCuerpo;
import excepciones.ExcepcionCuerpoCeleste;
import java.io.Serializable;

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
//            exCodigoCuerpo(codigoCuerpo);
//            exDiametro(diametro);
//            exTipoCuerpo(tipoCuerpo);
//            exNombre(nombre);

            this.codigoCuerpo = codigoCuerpo;
            this.nombre = nombre;
            this.tipoCuerpo = tipoCuerpo;
            this.diametro = diametro;
        } catch (ExcepcionCuerpoCeleste e) {
            System.out.println(e.getMessage());
        }
//        catch (ExcepcionCodigoCuerpo e) {
//            System.out.println(e.getMessage());
//        } catch (ExcepcionDiametro e) {
//            System.out.println(e.getMessage());
//        } catch (ExcepcionNombre e) {
//            System.out.println(e.getMessage());
//        } catch (ExcepcionTipoObjeto e) {
//            System.out.println(e.getMessage());
//        }catch (Exception ex) {
//            System.out.println(ex);
//        }
    }

    public int getDiametro() {
        return diametro;
    }

//    public void setDiametro(int diametro) {
//        try {
//            exDiametro(diametro);
//            this.diametro = diametro;
//        } catch (ExcepcionDiametro e) {
//            System.out.println(e.getMessage());
//        }
//    }
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

//    public void setCodigoCuerpo(int codigoCuerpo) {
//        try {
//            exCodigoCuerpo(codigoCuerpo);
//            this.codigoCuerpo = codigoCuerpo;
//        } catch (ExcepcionCodigoCuerpo e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public String getNombre() {
        return nombre;
    }

//    public void setNombre(String nombre) {
//        try {
//            exNombre(nombre);
//            this.nombre = nombre;
//        } catch (ExcepcionNombre e) {
//            System.out.println(e.getMessage());
//        }
//    }
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

//    public void setTipoCuerpo(String tipoCuerpo) {
//        try {
//            exTipoCuerpo(tipoCuerpo);
//            this.tipoCuerpo = tipoCuerpo;
//        } catch (ExcepcionTipoObjeto e) {
//            System.out.println(e.getMessage());
//        }
//    }
    @Override
    public String toString() {
        return "CuerpoCeleste: codigoCuerpo=" + codigoCuerpo + ", nombre=" + nombre + ", tipoCuerpo=" + tipoCuerpo + ", diametro=" + diametro;
    }

    private void exCuerpoCeleste(int codigoCuerpo, String nombre, String tipoCuerpo, int diametro) throws ExcepcionCuerpoCeleste {
        if (Integer.toString(codigoCuerpo).length()!=3) {
            throw new ExcepcionCuerpoCeleste("¡ERROR! El código debe ser un número entero de 3 dígitos.");
        } else if (nombre.length() > 15) {
            throw new ExcepcionCuerpoCeleste("¡ERROR! El nombre no debe exceder los 15 caracteres.");
        } else if (!"luna".equalsIgnoreCase(tipoCuerpo) && !"planeta enano".equalsIgnoreCase(tipoCuerpo) && !"planeta".equalsIgnoreCase(tipoCuerpo)) {
            throw new ExcepcionCuerpoCeleste("¡ERROR! Debe introducir tipos correctos ('luna', 'planeta enano', 'planeta').");
        } else if (Integer.toString(diametro).length() > 6) {
            throw new ExcepcionCuerpoCeleste("¡ERROR! El diámetro debe ser un número entero de 6 dígitos como máximo.");
        }
    }
//    public void exCodigoCuerpo(int codigoCuerpo) throws ExcepcionCodigoCuerpo {
//         if (codigoCuerpo<=0||codigoCuerpo>999) {
//            throw new ExcepcionCodigoCuerpo("¡ERROR! El código debe ser un número entero de 3 dígitos.");
//        }
//    }
//
//    public void exDiametro(int diametro) throws ExcepcionDiametro {
//        if (Integer.toString(diametro).length()>6) {
//            throw new ExcepcionDiametro("¡ERROR! El diámetro debe ser un número entero de 6 dígitos como máximo.");
//        }
//    }
//
//    public void exTipoCuerpo(String tipoCuerpo) throws ExcepcionTipoObjeto {
//        if (!"luna".equalsIgnoreCase(tipoCuerpo) && !"planetaEnano".equalsIgnoreCase(tipoCuerpo) && !"planeta".equalsIgnoreCase(tipoCuerpo)) {
//            throw new ExcepcionTipoObjeto("¡ERROR! Debe introducir un tipo correcto ('luna', 'planetaEnano', 'planeta').");
//        }
//    }
//
//    public void exNombre(String nombre) throws ExcepcionNombre {
//        if (nombre.length() > 15) {
//            throw new ExcepcionNombre("¡ERROR! El nombre no debe exceder los 15 caracteres.");
//        }
//    }
}
