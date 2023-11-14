package com.mycompany.cuentasbancarias;

import java.util.Scanner;

/**
 *
 * @author Emerson
 */
public class CuentasBancarias {

    private double saldoCuenta1;
    private double saldoCuenta2;

    public CuentasBancarias(double saldoInicialCuenta1, double saldoInicialCuenta2) {
        saldoCuenta1 = saldoInicialCuenta1;
        saldoCuenta2 = saldoInicialCuenta2;
    }

    public void depositar(int cuenta, double monto) {
        if (cuenta == 1) {
            saldoCuenta1 += monto;
            System.out.println("Depósito de Q" + monto + " realizado en la cuenta 1.");
        } else if (cuenta == 2) {
            saldoCuenta2 += monto;
            System.out.println("Depósito de Q" + monto + " realizado en la cuenta 2.");
        } else {
            System.out.println("Cuenta no válida.");
        }
    }

    public void consultarSaldos() {
        System.out.println("Saldo de la cuenta 1: Q" + saldoCuenta1);
        System.out.println("Saldo de la cuenta 2: Q" + saldoCuenta2);
    }

    public void debitar(int cuenta, double monto) {
        if (cuenta == 1) {
            if (saldoCuenta1 >= monto) {
                saldoCuenta1 -= monto;
                System.out.println("Retiro de Q" + monto + " realizado en la cuenta 1.");
            } else {
                System.out.println("Saldo insuficiente en la cuenta 1.");
            }
        } else if (cuenta == 2) {
            if (saldoCuenta2 >= monto) {
                saldoCuenta2 -= monto;
                System.out.println("Retiro de Q" + monto + " realizado en la cuenta 2.");
            } else {
                System.out.println("Saldo insuficiente en la cuenta 2.");
            }
        } else {
            System.out.println("Cuenta no válida.");
        }
    }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double saldoInicialCuenta1 = 1000.0;
            double saldoInicialCuenta2 = 2000.0;
            CuentasBancarias cuentas = new CuentasBancarias(saldoInicialCuenta1, saldoInicialCuenta2);

            int opcion;

            do {
                System.out.println("1. Depositar en cuenta");
                System.out.println("2. Debitar de cuenta");
                System.out.println("3. Consultar saldos");
                System.out.println("4. Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el número de cuenta (1 o 2): ");
                        int cuentaDeposito = scanner.nextInt();
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        cuentas.depositar(cuentaDeposito, montoDeposito);
                        break;

                    case 2:
                        System.out.print("Ingrese el número de cuenta (1 o 2): ");
                        int cuentaRetiro = scanner.nextInt();
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        cuentas.debitar(cuentaRetiro, montoRetiro);
                        break;

                    case 3:
                        cuentas.consultarSaldos();
                        break;

                    case 4:
                        System.out.println("Gracias por utilizar el programa.");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

            } while (opcion != 4);
        }
    }
