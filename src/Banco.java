import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombreCliente = "Tony Stark";
        String tipoCuenta = "Corriente";
        double saldoDisponible = 1599.99;
        String datosCliente = """
                 ******************************************
                
               
                 Nombre del Cliente:"""  + " " + nombreCliente +

                """
               
                Tipo de Cuenta:""" + " " + tipoCuenta +

                """
              
                Saldo Disponible:""" + " $" + saldoDisponible;
        String menuInicial = """
       
                
                ******************************************
                **Escriba en numero de la opcion deseada**
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                9 - Salir
                
                """;
        System.out.println (datosCliente + menuInicial);
        int numeroDeOpcion = teclado.nextInt();

        while (numeroDeOpcion != 9) {

            switch (numeroDeOpcion) {
                case 1:
                    System.out.println("Saldo disponible: " + saldoDisponible);
                    System.out.println(menuInicial);
                    numeroDeOpcion = teclado.nextInt();
                    break;

                case 2:
                    System.out.println("Ingrese monto a retirar");
                    double retiro = teclado.nextDouble();
                    if (saldoDisponible < retiro) {
                        System.out.println("¡Saldo insuficiente!");

                    } else {
                        System.out.println("""
                                    ¿El monto esta correcto?
                                    1 - SI.
                                    2 - NO.
                                    """);
                        int numeroDeOpcionConfirmacion = teclado.nextInt();
                        if (numeroDeOpcionConfirmacion == 1) {
                            saldoDisponible = saldoDisponible-retiro;
                            System.out.println("!Retiro exitoso!. Actualmente " + nombreCliente + " tiene en su cuenta: " + saldoDisponible);
                        } else {
                            System.out.println("Monto no confirmado");
                        }
                    }

                    System.out.println(menuInicial);
                    numeroDeOpcion = teclado.nextInt();
                    break;

                case 3:
                    System.out.println("Ingrese monto a depositar");
                    double deposito = teclado.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("¡Ingrese monto valido!");
                    } else {
                        System.out.println("""
                                    ¿El monto esta correcto?
                                    1 - SI.
                                    2 - NO.
                                    """);
                        int numeroDeOpcionConfirmacion = teclado.nextInt();
                        if (numeroDeOpcionConfirmacion == 1) {
                            saldoDisponible = saldoDisponible + deposito;
                            System.out.println("!Deposito exitoso!. Actualmente " + nombreCliente + " tiene en su cuenta: " + saldoDisponible);
                        } else {
                            System.out.println("Monto no confirmado");
                        }
                    }
                    System.out.println(menuInicial);
                    numeroDeOpcion = teclado.nextInt();
                    break;

                default:
                    System.out.println("¡Ingrese opcion valida!");
                    System.out.println(menuInicial);
                    numeroDeOpcion = teclado.nextInt();
                    break;
            }
        }
    }
}