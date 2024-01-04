import personas.Personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Personas> listaPersonas = new ArrayList<>();

        var salir = false;
        while (!salir){
            mostarMenu();
            try {
                salir = ejecutarOperacion(input,listaPersonas);
            }catch (Exception e){
                System.out.println("Ocurrio un error " +e.getMessage());
            }
        }
    }

    private static void mostarMenu(){
        System.out.println("**** Listado de Personas ****");
        System.out.println("1.Agregar \n2.Listar \n3.Salir");
        System.out.print("Proporciona la opcion? : ");
    }

    private static boolean ejecutarOperacion(Scanner input, List<Personas> personas){
        var opcion = Integer.parseInt(input.nextLine());
        var salir = false;

        switch (opcion){
            case 1 : //Agregar personas a la lista
                System.out.print("Proporciona el nombre : ");
                var nombre = input.nextLine();
                System.out.print("Proporciona el telefono : ; ");
                var telefono = input.nextLine();
                System.out.print("Proporciona el email ; ");
                var email = input.nextLine();
                //Crear el objeto tipo persona
                var persona = new Personas(nombre,telefono,email);
                //agregamos a la lista de personas
                personas.add(persona);
                System.out.println("La lista tiene  " +personas.size() + " personas");
                break;
            case 2: //Listar Personas
                System.out.println("Listado de Personas : ");
                personas.forEach(System.out::println);
                break;
            case 3://salir
                System.out.println("Hasta Pronto ... ");
                salir = true;
                break;
            default:
                System.out.println("Opcion Errornea " +opcion);
        }
        return salir;
    }
}