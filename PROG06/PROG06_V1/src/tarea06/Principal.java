package tarea06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        iniciarPrograma();

    }

    private static void agregarPersona(Gimnasio gimnasio) {
        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);
        System.out.println("Introduzca los datos de la persona a dar de alta.");
        System.out.println("Nombre");
        String nombre = sn.nextLine();
        while (!Validacion.validarNombre(nombre)) {
            System.out.println("El nombre debe tener más de 20 caracteres (Solo letras).");
            nombre = sn.nextLine();
        }

        System.out.println("DNI");
        String dni = sn.nextLine();
        while (!Validacion.validarDni(dni) || gimnasio.buscaPersona(dni)) {
            if (!Validacion.validarDni(dni)) {
                System.out.println("El DNI debe tener 8 números y una letra mayúscula.");
            } else {
                System.out.println("Ya existe una persona con el DNI introducido.");
            }
            System.out.println("Introduzca el DNI de nuevo:");
            dni = sn.nextLine();
        }

        System.out.println("Fecha de nacimiento (DD/MM/YYYY)");
        String fechaNacimiento = sn.nextLine();
        while (!Validacion.validarFormatoFecha(fechaNacimiento)) {
            System.out.println("Error: Formato de fecha incorrecto.");
            System.out.println("Introduzca la fecha correcta en formato DD/MM/YYYY:");
            fechaNacimiento = sn.nextLine();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);

        System.out.println("Sexo (H/M)");
        String sexo = sn.nextLine();
        while (!Persona.comprobarSexo(sexo)) {
            System.out.println("El sexo debe ser 'H' (Hombre) o 'M' (Mujer).");
            System.out.println("Introduzca de nuevo el sexo:");
            sexo = sn.nextLine();
        }
        char sexoPersona = sexo.charAt(0);

        System.out.println("Peso (KG)");
        double peso = sn.nextDouble();

        System.out.println("Altura (Metros)");
        double altura = sn.nextDouble();
        sn.nextLine();
        System.out.println("Codigo de taquilla");
        String codigoTaquilla = sn.nextLine();
        while (!Validacion.validarCodigoTaquilla(codigoTaquilla)) {
            System.out.println("El código de la taquilla debe tener dos letras y tres números.");
            System.out.println("Introduzca el código de la taquilla de nuevo:");
            codigoTaquilla = sn.nextLine();
        }

        Persona persona = new Persona(nombre, dni, codigoTaquilla, fecha, sexoPersona, peso, altura);

        if (gimnasio.anadePersona(persona)) {
            System.out.println("Nueva persona añadida correctamente al gimnasio.\n");
        } else {
            System.out.println("ERROR. Se ha llegado al límite de personas que se pueden registrar.\n");
        }
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        Gimnasio gimnasio = new Gimnasio();

        int opcion = 0;
        while (opcion != 6) {
            try {

                System.out.println("1. Nueva Persona.");
                System.out.println("2. Buscar Persona.");
                System.out.println("3. Modificar código taquilla.");
                System.out.println("4. Listar  Personas.");
                System.out.println("5. Eliminar Persona.");
                System.out.println("6. Salir.");
                System.out.println("Seleccione una opción: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        agregarPersona(gimnasio);
                        break;
                    case 2:
                        buscarPersona(gimnasio);
                        break;
                    case 3:
                        modificarCodigoTaquilla(gimnasio);
                        break;
                    case 4:
                        listarPersonas(gimnasio);
                        break;
                    case 5:
                        eliminarPersona(gimnasio);
                        break;
                    case 6:
                        salir();
                        break;
                    default:
                        System.out.println("¡ERROR!. Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                sn.next();
            }
        }
    }

    private static void buscarPersona(Gimnasio gimnasio) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Introduzca el DNI de la persona que busca:");
        String dni = sn.nextLine();

        if (!Validacion.validarDni(dni)) {
            System.out.println("El DNI debe tener 8 números y una letra mayúscula.\nIntroduzca el DNI de nuevo:");
            dni = sn.nextLine();
        }

        Persona persona = gimnasio.devuelvePersona(dni);

        if (persona != null) {
            System.out.println("Datos de la persona solicitada:");
            System.out.println("DNI: " + persona.getDni());
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Código de taquilla: " + persona.getCodigoTaquilla() + "\n");
        } else {
            System.out.println("No existe Persona con el DNI introducido.\n");
        }

    }

    private static void listarPersonas(Gimnasio gimnasio) {
        gimnasio.listarPersonas();
    }

    private static void modificarCodigoTaquilla(Gimnasio gimnasio) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Introduzca el DNI de la persona que busca:");
        String dni = sn.nextLine();

        while (!Validacion.validarDni(dni)) {
            System.out.println("El DNI debe tener 8 números y una letra mayúscula.\nIntroduzca el DNI de nuevo:");
            dni = sn.nextLine();
        }

        boolean existeDni = gimnasio.buscaPersona(dni);

        if (!existeDni) {
            System.out.println("No existe una persona con el DNI introducido.");
        } else {
            System.out.println("Introduzca el nuevo código de taquilla:");
            String codTaquilla = sn.nextLine();

            while (!Validacion.validarCodigoTaquilla(codTaquilla)) {
                System.out.println("El código de la taquilla debe tener dos letras y tres números.");
                System.out.println("Introduzca el código de la taquilla de nuevo:");
                codTaquilla = sn.nextLine();
            }

            gimnasio.actualizaTaquilla(dni, codTaquilla);
            System.out.println("Código de taquilla actualizado.\n");
        }
    }

    private static void eliminarPersona(Gimnasio gimnasio) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Introduzca el DNI de la persona que desea eliminar del registro:");
        String dni = sn.nextLine();

        while (!Validacion.validarDni(dni)) {

            System.out.println("El DNI debe tener 8 números y una letra mayúscula.");
            System.out.println("Introduzca un DNI válido.");
            dni = sn.nextLine();
        }
        if (!gimnasio.buscaPersona(dni)) {
            System.out.println("No existe Persona con el DNI introducido.");
        } else {
            gimnasio.eliminaPersona(dni);
            System.out.println("Persona borrada del registro.\n");
        }
    }

    public static void salir() {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        do {
            System.out.println("¿Quiere salir? (S/N)");
            String continuar = sn.next();

            if ("s".equalsIgnoreCase(continuar)) {
                System.out.println("Fin del programa. ¡Hasta luego!");
                salir = true;

            } else if ("n".equalsIgnoreCase(continuar)) {
                salir = true;
                iniciarPrograma();
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }
}
