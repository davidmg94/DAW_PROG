package ejer_banco;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

        Banco banco = new Banco();

        int opcion = 0;

        while (opcion != 8) {
            try {
                System.out.println("1. Abrir una nueva cuenta.");
                System.out.println("2. Ver un listado de las cuentas disponibles.");
                System.out.println("3. Obtener los datos de una cuenta concreta.");
                System.out.println("4. Realizar un ingreso en una cuenta.");
                System.out.println("5. Retirar efectivo de una cuenta.");
                System.out.println("6. Consultar el saldo actual de una cuenta.");
                System.out.println("7. Eliminar una cuenta.");
                System.out.println("8. Salir de la aplicación.");
                System.out.println("Seleccione una opción: ");

                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        abrirCuenta(banco, entrada);
                        break;
                    case 2:
                        listadoCuentas(banco);
                        break;
                    case 3:
                        obtenerDatosCuenta(banco, entrada);
                        break;
                    case 4:
                        ingresoCuenta(banco, entrada);
                        break;
                    case 5:
                        retiradaCuenta(banco, entrada);
                        break;
                    case 6:
                        consultarSaldo(banco, entrada);
                        break;
                    case 7:
                        eliminarCuenta(banco, entrada);
                        break;
                    case 8:
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

    private static void abrirCuenta(Banco banco, Scanner entrada) {

        String nombreTitular, apellidoTitular, dniTitular, IBAN, entidadesAutorizadas;
        double saldoInicial, tpoInteres, comisionMantenimiento, maximoDescubierto, tipoInteresDescubierto, comisionDescubierto;

        Persona titular = null;
        CuentaBancaria cuenta = null;

        System.out.println("Introduce el nombre del titular.");
        nombreTitular = entrada.next();

        while (!Validacion.validarNombre(nombreTitular)) {
            System.out.println("El nombre debe tener menos de 40 caracteres (Solo letras).");
            nombreTitular = entrada.next();
        }
        System.out.println("Introduce el apellido del titular.");
        apellidoTitular = entrada.next();
        while (!Validacion.validarNombre(apellidoTitular)) {
            System.out.println("ERROR. Los caracteres del apellido solo pueden ser letras.");
            apellidoTitular = entrada.next();
        }
        System.out.println("Introduce el dni del titular.");
        dniTitular = entrada.next();
        while (!Validacion.validarDni(dniTitular)) {
            System.out.println("El DNI no tiene el formato correcto.");
            dniTitular = entrada.next();
        }

        titular = new Persona(nombreTitular, apellidoTitular, dniTitular);

        System.out.println("Introduce el IBAN de la cuenta.");
        IBAN = entrada.next();
        while (!Validacion.validarIBAN(IBAN) || banco.buscarCuenta(IBAN) != null) {
            if (!Validacion.validarIBAN(IBAN)) {
                System.out.println("El IBAN no tiene el formato correcto.");
            } else {
                System.out.println("Ya existe esa cuenta bancaria.");
            }
            System.out.println("Introduzca el IBAN de nuevo:");
            IBAN = entrada.next();
        }

        System.out.println("Introduce el saldo inicial de la cuenta.");
        saldoInicial = entrada.nextDouble();

        int tipoCuenta = 0;

        do {
            try {
                System.out.println("Elige el tipo de cuenta que se desea abrir.");
                System.out.println("1. Cuenta ahorro");
                System.out.println("2. Cuenta corriente personal");
                System.out.println("3. Cuenta corriente empresa");
                tipoCuenta = entrada.nextInt();

                switch (tipoCuenta) {
                    case 1:
                        System.out.println("Introduce el tipo de interés.");
                        tpoInteres = entrada.nextDouble();

                        cuenta = new CuentaAhorro(tpoInteres, titular, saldoInicial, IBAN);

                        break;
                    case 2:
                        System.out.println("Introduce una lista de autoridades autorizadas.");
                        entidadesAutorizadas = entrada.next();

                        System.out.println("Introduce la comisión de mantenimiento");
                        comisionMantenimiento = entrada.nextDouble();

                        cuenta = new CuentaCorrientePersonal(comisionMantenimiento, entidadesAutorizadas, titular, saldoInicial, IBAN);

                        break;
                    case 3:
                        System.out.println("Introduce una lista de autoridades autorizadas.");
                        entidadesAutorizadas = entrada.next();

                        System.out.println("Introduce el tipo de interés.");
                        tipoInteresDescubierto = entrada.nextDouble();

                        System.out.println("Introduce máximo descubierto permitido.");
                        maximoDescubierto = entrada.nextDouble();

                        System.out.println("Introduce la comisión por descubierto.");
                        comisionDescubierto = entrada.nextDouble();

                        cuenta = new CuentaCorrienteEmpresa(tipoInteresDescubierto, maximoDescubierto, comisionDescubierto, entidadesAutorizadas, titular, saldoInicial, IBAN);

                        break;
                    default:
                        System.out.println("¡ERROR!. Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                entrada.next();
            }
        } while (tipoCuenta != 1 && tipoCuenta != 2 && tipoCuenta != 3);

        if (banco.abrirCuenta(cuenta)) {
            System.out.println("Se ha abierto la cuenta con éxito.");
        } else {
            System.out.println("¡ERROR! No se ha podido abrir la cuenta.");
        }
    }

    private static void listadoCuentas(Banco banco) {
        System.out.println("Cuentas registradas.");
        String[] infoCuentas = banco.listadoCuentas();
        for (String info : infoCuentas) {
            System.out.println(info);
        }
    }

    private static void obtenerDatosCuenta(Banco banco, Scanner entrada) {
        while (true) {
            System.out.println("Introduce el IBAN de la cuenta.");
            String IBAN = entrada.next();
            while (!Validacion.validarIBAN(IBAN)) {
                System.out.println("El IBAN no tiene el formato correcto.\nInténtelo de nuevo");
                IBAN = entrada.next();
            }
            String infoCuenta = banco.informacionCuenta(IBAN);
            if (infoCuenta != null) {
                System.out.println("Datos de la cuenta: " + infoCuenta);
                System.out.println("");
                break;
            } else {
                System.out.println("No existe esa cuenta.\nIntroduzca otra cuenta.");
            }
        }
    }

    private static void ingresoCuenta(Banco banco, Scanner entrada) {
        while (true) {
            System.out.println("Introduce el IBAN de la cuenta.");
            String IBAN = entrada.next();
            while (!Validacion.validarIBAN(IBAN)) {
                System.out.println("El IBAN no tiene el formato correcto.\nInténtelo de nuevo");
                IBAN = entrada.next();
            }
            String infoCuenta = banco.informacionCuenta(IBAN);
            if (infoCuenta != null) {
                System.out.println("Introduce la cantidad que desea ingresar.");
                double cantidad = entrada.nextDouble();
                banco.ingresoCuenta(IBAN, cantidad);
                System.out.println("Ingreso realizado con éxito en la cuenta " + IBAN + ".");
                System.out.println("");
                break;
            } else {
                System.out.println("No existe esa cuenta.\nIntroduzca otra cuenta.");
            }
        }
    }

    private static void retiradaCuenta(Banco banco, Scanner entrada) {
        while (true) {
            System.out.println("Introduce el IBAN de la cuenta.");
            String IBAN = entrada.next();
            while (!Validacion.validarIBAN(IBAN)) {
                System.out.println("El IBAN no tiene el formato correcto.\nInténtelo de nuevo");
                IBAN = entrada.next();
            }
            String infoCuenta = banco.informacionCuenta(IBAN);
            if (infoCuenta != null) {
                System.out.println("Introduce la cantidad que desea retirar.");
                double cantidad = entrada.nextDouble();
                banco.retiradaCuenta(IBAN, cantidad);
                System.out.println("Retirada de efectivo realizada con éxito de la cuenta " + IBAN + ".");
                System.out.println("");
                break;
            } else {
                System.out.println("No existe esa cuenta.\nIntroduzca otra cuenta.");
            }
        }
    }

    private static void consultarSaldo(Banco banco, Scanner entrada) {
        while (true) {
            System.out.println("Introduce el IBAN de la cuenta.");
            String IBAN = entrada.next();
            while (!Validacion.validarIBAN(IBAN)) {
                System.out.println("El IBAN no tiene el formato correcto.\nInténtelo de nuevo.");
                IBAN = entrada.next();
            }

            String infoCuenta = banco.informacionCuenta(IBAN);
            if (infoCuenta != null) {
                System.out.println("Saldo de la cuenta: " + banco.saldoCuenta(IBAN) + "$");
                System.out.println("");
                break;
            } else {
                System.out.println("No existe esa cuenta.\nInténtelo de nuevo.");
            }
        }
    }

    private static void eliminarCuenta(Banco banco, Scanner entrada) {
        while (true) {
            System.out.println("Introduce el IBAN de la cuenta.");
            String IBAN = entrada.next();
            while (!Validacion.validarIBAN(IBAN) || !banco.eliminarCuenta(IBAN)) {
                if (!Validacion.validarIBAN(IBAN)) {
                    System.out.println("El IBAN no tiene el formato correcto.\nInténtelo de nuevo");
                } else {
                    System.out.println("No se puede eliminar esa cuenta.\nCompruebe que ha introducido correctamente el IBAN y su saldo sea 0.");
                }
                System.out.println("Inténtelo de nuevo.");
                IBAN = entrada.next();
            }
            System.out.println("Cuenta eliminada con éxito.");
            break;
        }
    }
}
