import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombreCliente = "Tony Stark";
        String tipoCuenta = "Corriente";
        double saldoDisponible = 1599.99;
        int numeroDeOpcion = 0;
        System.out.println("********************************************");
        System.out.println("Nombre del Cliente: " + nombreCliente);
        System.out.println("Tipo de Cuenta: " + tipoCuenta);
        System.out.println("Saldo Disponible: " + saldoDisponible +"$");
        System.out.println("\n********************************************");

        String menuInicial = """
                \n***Escriba en numero de la opcion deseada***
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                9 - Salir
                \n""";
        while (numeroDeOpcion != 9) {
            System.out.println (menuInicial);
            numeroDeOpcion = teclado.nextInt();
            switch (numeroDeOpcion) {
                case 1:
                    System.out.println("Saldo disponible: " + saldoDisponible);
                    break;
                case 2:
                    System.out.println("Ingrese monto a retirar");
                    double valorARetirar = teclado.nextDouble();
                    if (saldoDisponible < valorARetirar) {
                        System.out.println("Saldo insuficiente");
                        }else{
                        System.out.println("""
                                    ¿El monto esta correcto?
                                    1 - SI.
                                    2 - NO.
                                    """);
                        int numeroDeOpcionConfirmacion = teclado.nextInt();
                        if (numeroDeOpcionConfirmacion == 1) {
                            saldoDisponible -= valorARetirar;
                            System.out.println("!Retiro exitoso!. El saldo actualizado es: " + saldoDisponible);
                            }else{
                            System.out.println("Monto no confirmado");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese monto a depositar");
                    double valorADepositar = teclado.nextDouble();
                    if (valorADepositar <= 0) {
                        System.out.println("¡Ingrese monto valido!");
                    }else{
                        System.out.println("""
                                    ¿El monto esta correcto?
                                    1 - SI.
                                    2 - NO.
                                    """);
                        int numeroDeOpcionConfirmacion = teclado.nextInt();
                        if (numeroDeOpcionConfirmacion == 1) {
                            saldoDisponible += valorADepositar;
                            System.out.println("!Deposito exitoso!. El saldo actualizado es: " + saldoDisponible);
                        }else{
                            System.out.println("Monto no confirmado");
                        }
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa. ¡Gracias por utilizar nuestros servicios!");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}