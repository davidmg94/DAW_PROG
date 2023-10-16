package prog05_tarea;

/**
 *
 * @author David
 */
import java.util.Scanner;

import consultorio_medico.Paciente;
import consultorio_medico.Medico;
import consultorio_medico.Utilidades;
import consultorio_medico.Visitas;
import java.util.InputMismatchException;

public class Principal {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        boolean codigoMedicoCorrecto = false;
        String codigoPac, nombrePac, apellidoPac, codigoMed, nombreMed, dniMed;
        enumEspecialidad especialidad = null;
        Visitas visita1 = null, visita2 = null, visita3 = null, visita4 = null, visita5 = null;
        Paciente paciente1 = null, paciente2 = null, paciente3 = null;
        Medico medico1 = null, medico2 = null, medico3 = null, medico4 = null;
        int opcion = 0, opcionEsp = 0;
        do {
            try {

                System.out.println("""
                                           1. Inicializar valores
                                           2. Pacientes
                                           3. Médicos
                                           4. Visitas
                                           5. Imprimir visitas
                                           6. Imprimir total de visitas por tipos
                                           7. Salir""");
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        Visitas.reinicializarVisita();
                        System.out.println("Las visitas se han reiniciado");
                        break;

                    case 2:
                        System.out.println("Introduce los datos del paciente 1:\n");

                        System.out.println("Introduzca el código del paciente:");
                        codigoPac = entrada.next();

                        System.out.println("Introduzca el nombre del paciente:");
                        nombrePac = entrada.next();

                        System.out.println("Introduzca el apellido del paciente:");
                        apellidoPac = entrada.next();
                        System.out.println("\nNombre del paciente: \n" + nombrePac + "\nApellido del paciente: \n" + apellidoPac);
                        paciente1 = new Paciente(codigoPac, nombrePac, apellidoPac);

                        System.out.println("\nAhora se insertaran el resto de pacientes de manera automática:\n");
                        paciente2 = new Paciente("D456", "David", "Medina");
                        System.out.println("Paciente 2: " + paciente2.getCodigoPac() + ", " + paciente2.getNombrePac() + ", " + paciente2.getApellidoPac());
                        paciente3 = new Paciente("C321", "Claudia", "Fernández");
                        System.out.println("Paciente 3: " + paciente3.getCodigoPac() + ", " + paciente3.getNombrePac() + ", " + paciente3.getApellidoPac());
                        System.out.println("");
                        break;

                    case 3:
                        System.out.println("Introduce los datos del médico 1:\n");
                        codigoMedicoCorrecto = false;

                        do {
                            System.out.println("Introduce el código del médico:");
                            codigoMed = entrada.next();

                            try {
                                Utilidades.codigoValido(codigoMed);
                                codigoMedicoCorrecto = true;
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }

                        } while (!Utilidades.codigoValido(codigoMed));

                        System.out.println("Introduzca el nombre del médico:");
                        nombreMed = entrada.next();

                        System.out.println("Introduzca el DNI del médico:");
                        dniMed = entrada.next();

                        do {
                            if (!validaDNI(dniMed)) {
                                System.out.println("El formato del DNI no es correcto. Debe ser NNNNNNNNL. Introdúzcalo de nuevo, por favor.");
                                dniMed = entrada.nextLine();
                            }
                        } while (!validaDNI(dniMed));
                        System.out.println("");
                        System.out.println("Escoge la especialidad del médico:");

                        do {
                            System.out.println("""
                       - Escoge 0 si la especialidad es Médico de cabecera
                       - Escoge 1 si la especialidad es Traumatología
                       - Escoge 2 si la especialidad es Digestivo
                       - Escoge 3 si la especialidad es Ginecología""");
                            opcionEsp = entrada.nextInt();

                            switch (opcionEsp) {
                                case 0:
                                    especialidad = enumEspecialidad.MCABECERA;
                                    break;
                                case 1:
                                    especialidad = enumEspecialidad.TRAUMATOLOGIA;
                                    break;
                                case 2:
                                    especialidad = enumEspecialidad.DIGESTIVO;
                                    break;
                                case 3:
                                    especialidad = enumEspecialidad.GINECOLOGIA;
                                    break;
                                default:
                                    System.out.println("ERROR: debe elegir una especialidad correcta.\n");
                                    break;
                            }

                        } while (opcionEsp != 3 && opcionEsp != 0 && opcionEsp != 1 && opcionEsp != 2);

                        System.out.println("Codigo:\n" + codigoMed + "\nNombre del médico: \n" + nombreMed + "\nDni del medico:\n" + dniMed + "\nEspacialidad:\n" + especialidad);
                        medico1 = new Medico(codigoMed, nombreMed, dniMed, especialidad);

                        System.out.println("\nAhora se insertaran el resto de médicos de manera automática:\n");
                        medico2 = new Medico("DI0001,", "dni2", "Marian,", enumEspecialidad.DIGESTIVO);
                        System.out.println("Médico 2: " + medico2.getCodigoMed() + ", " + medico2.getNombreMed() + ", " + medico2.getDniMed() + ", " + medico2.getEspecialidad());
                        medico3 = new Medico("DI0001,", "dni3", "Ana Paz", enumEspecialidad.GINECOLOGIA);
                        System.out.println("Médico 3: " + medico3.getCodigoMed() + ", " + medico3.getNombreMed() + ", " + medico3.getDniMed() + ", " + medico3.getEspecialidad());
                        medico4 = new Medico("DI0001,", "dni4", "Pedro", enumEspecialidad.TRAUMATOLOGIA);
                        System.out.println("Médico 4: " + medico4.getCodigoMed() + ", " + medico4.getNombreMed() + ", " + medico4.getDniMed() + ", " + medico4.getEspecialidad());
                        System.out.println("");
                        break;

                    case 4:
                        if (paciente1 != null && medico1 != null) {
                            visita1 = new Visitas("1", "8/02/2022", paciente1, medico1, 0, "Descipcion1", "Tratamiento1", Utilidades.precioVisita(Visitas.CONSULTA, medico1.getEspecialidad(), Visitas.PRECIO_MINIMO));
                            Visitas.incrementarVisita(0);
                            visita2 = new Visitas("2", "10/02/2022", paciente1, medico1, 1, "Descipcion2", "Tratamiento2", Utilidades.precioVisita(Visitas.REVISION, medico1.getEspecialidad(), Visitas.PRECIO_MINIMO));
                            Visitas.incrementarVisita(1);
                            visita3 = new Visitas("3", "10/02/2022", paciente2, medico2, 2, "Descipcion3", "Tratamiento3", Utilidades.precioVisita(Visitas.RECETAS, medico2.getEspecialidad(), Visitas.PRECIO_MINIMO));
                            Visitas.incrementarVisita(2);
                            visita4 = new Visitas("4", "11/02/2022", paciente3, medico3, 3, "Descipcion4", "Tratamiento4", Utilidades.precioVisita(Visitas.URGENCIAS, medico3.getEspecialidad(), Visitas.PRECIO_MINIMO));
                            Visitas.incrementarVisita(3);
                            visita5 = new Visitas("5", "11/02/2022", paciente2, medico4, 0, "Descipcion5", "Tratamiento5", Utilidades.precioVisita(0, medico4.getEspecialidad(), Visitas.PRECIO_MINIMO));
                            Visitas.incrementarVisita(0);
                            System.out.println("Visita 1: " + visita1.toString());
                            System.out.println("\nVisita 2: " + visita2.toString());
                            System.out.println("\nVisita 3: " + visita3.toString());
                            System.out.println("\nVisita 4: " + visita4.toString());
                            System.out.println("\nVisita 5: " + visita5.toString());
                            System.out.println("");
                        } else {
                            System.out.println("Debe realizar el paso 2 y 3 anteriormente, para introducir los datos del paciente y del médico");
                        }
                        break;

                    case 6:
                        System.out.println("- Numero de consultas: " + Visitas.devuelveNumVisita(0));
                        System.out.println("- Numero de consultas: " + Visitas.devuelveNumVisita(1));
                        System.out.println("- Numero de consultas: " + Visitas.devuelveNumVisita(2));
                        System.out.println("- Numero de consultas: " + Visitas.devuelveNumVisita(3));
                        System.out.println("");
                        break;
                    case 7:
                        System.out.println("¡HASTA LUEGO!");
                        break;
                    default:
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                entrada.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 7);
    }

    public static boolean validaDNI(String dni) {
        return dni.matches("^[0-9]{8}[A-Z]$");
    }
}
