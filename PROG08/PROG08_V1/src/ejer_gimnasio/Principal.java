package ejer_gimnasio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        Gimnasio gimnasio = new Gimnasio();
        
        int opcion = 0;
        while (opcion != 7) {
            try {

                System.out.println("1. Nueva Persona.");
                System.out.println("2. Buscar Persona.");
                System.out.println("3. Modificar código taquilla.");
                System.out.println("4. Listar  Personas.");
                System.out.println("5. Eliminar Persona.");
                System.out.println("6. Lista ordenada por DNI.");
                System.out.println("7. Salir.");
                System.out.println("Seleccione una opción: ");
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        agregarPersona(gimnasio, entrada);
                        break;
                    case 2:
                        buscarPersona(gimnasio, entrada);
                        break;
                    case 3:
                        modificarCodigoTaquilla(gimnasio, entrada);
                        break;
                    case 4:
                        listarPersonas(gimnasio);
                        break;
                    case 5:
                        eliminarPersona(gimnasio, entrada);
                        break;
                    case 6:
                        mostrarListaOrdenada(gimnasio);
                        break;
                    case 7:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("¡ERROR!. Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                entrada.next();
            }
        }
    }

    private static void agregarPersona(Gimnasio gimnasio, Scanner sn) {

        System.out.println("Introduzca los datos de la persona a dar de alta.");
        System.out.println("Nombre");
        String nombre = sn.next();
        while (!Validacion.validarNombre(nombre)) {
            System.out.println("El nombre debe tener mas de 20 caracteres (Solo letras).");
            nombre = sn.next();
        }

        System.out.println("DNI");
        String dni = sn.next();
        while (!Validacion.validarDni(dni) || gimnasio.buscaPersona(dni)) {
            if (!Validacion.validarDni(dni)) {
                System.out.println("El DNI debe tener 8 números y una letra mayúscula.");
            } else {
                System.out.println("Ya existe una persona con el DNI introducido.");
            }
            System.out.println("Introduzca el DNI de nuevo:");
            dni = sn.next();
        }

        System.out.println("Fecha de nacimiento (DD/MM/YYYY)");
        String fechaNacimiento = sn.next();
        while (!Validacion.validarFormatoFecha(fechaNacimiento)) {
            System.out.println("Error: Formato de fecha incorrecto.");
            System.out.println("Introduzca la fecha correcta en formato DD/MM/YYYY:");
            fechaNacimiento = sn.next();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);

        System.out.println("Sexo (H/M)");
        String sexo = sn.next();
        while (!Persona.comprobarSexo(sexo)) {
            System.out.println("El sexo debe ser 'H' (Hombre) o 'M' (Mujer).");
            System.out.println("Introduzca de nuevo el sexo:");
            sexo = sn.next();
        }
        char sexoPersona=sexo.charAt(0);

        System.out.println("Peso (KG)");
        double peso = sn.nextDouble();

        System.out.println("Altura (Metros)");
        double altura = sn.nextDouble();

        System.out.println("Codigo de taquilla");
        String codigoTaquilla = sn.next();
        while (!Validacion.validarCodigoTaquilla(codigoTaquilla)) {
            System.out.println("El código de la taquilla debe tener dos letras y tres números.");
            System.out.println("Introduzca el código de la taquilla de nuevo:");
            codigoTaquilla = sn.next();
        }

        Persona persona = new Persona(nombre, dni, codigoTaquilla, fecha, sexoPersona, peso, altura);

        if (gimnasio.anadePersona(persona)) {
            System.out.println("Nueva persona añadida correctamente al gimnasio.\n");
        } else {
            System.out.println("ERROR. Se ha llegado al límite de personas que se pueden registrar.\n");
        }
    }

    private static void buscarPersona(Gimnasio gimnasio, Scanner entrada) {
        while (true) {
            System.out.println("Introduzca el DNI de la persona que busca:");
            String dni = entrada.nextLine();

            if (!Validacion.validarDni(dni)) {
                System.out.println("El DNI debe tener 8 números y una letra mayúscula.\nIntroduzca el DNI de nuevo:");
                dni = entrada.nextLine();
            }

            Persona persona = gimnasio.devuelvePersona(dni);

            if (persona != null) {
                System.out.println("Datos de la persona solicitada:");
                System.out.println("DNI: " + persona.getDni());
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Código de taquilla: " + persona.getCodigoTaquilla() + "\n");
                break;
            } else {
                System.out.println("No existe Persona con el DNI introducido.");
            }
        }
    }

    private static void listarPersonas(Gimnasio gimnasio) {
        gimnasio.listarPersonas();
    }

    private static void modificarCodigoTaquilla(Gimnasio gimnasio, Scanner entrada) {
        while (true) {

            System.out.println("Introduzca el DNI de la persona que busca:");
            String dni = entrada.next();

            while (!Validacion.validarDni(dni)) {
                System.out.println("El DNI debe tener 8 números y una letra mayúscula.\nIntroduzca el DNI de nuevo:");
                dni = entrada.next();
            }

            boolean existeDni = gimnasio.buscaPersona(dni);

            if (!existeDni) {
                System.out.println("No existe una persona con el DNI introducido. Inténtelo de nuevo.");
            } else {
                System.out.println("Introduzca el nuevo código de taquilla:");
                String codTaquilla = entrada.next();

                while (!Validacion.validarCodigoTaquilla(codTaquilla)) {
                    System.out.println("El código de la taquilla debe tener dos letras y tres números.");
                    System.out.println("Introduzca el código de la taquilla de nuevo:");
                    codTaquilla = entrada.next();
                }

                gimnasio.actualizaTaquilla(dni, codTaquilla);
                System.out.println("Código de taquilla actualizado.\n");
                break;
            }
        }
    }

    private static void eliminarPersona(Gimnasio gimnasio, Scanner entrada) {
        while (true) {
            System.out.println("Introduzca el DNI de la persona que desea eliminar del registro:");
            String dni = entrada.next();

            while (!Validacion.validarDni(dni) || !gimnasio.eliminaPersona(dni)) {
                if (!Validacion.validarDni(dni)) {
                    System.out.println("El DNI debe tener 8 números y una letra mayúscula.");
                } else {
                    System.out.println("No existe Persona con el DNI introducido.");
                }
                System.out.println("Introduzca el DNI de nuevo:");
                dni = entrada.next();
            }
            System.out.println("Persona borrada del registro.\n");
            break;
        }
    }

    private static void mostrarListaOrdenada(Gimnasio gimnasio) {
        ArrayList<Persona> personasOrdenadas = gimnasio.personasOrdenadasPorDni();
        if (personasOrdenadas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Lista de personas ordenadas por DNI:");
            for (Persona persona : personasOrdenadas) {
                System.out.println(persona.toString());
            }
        }
    }
}
