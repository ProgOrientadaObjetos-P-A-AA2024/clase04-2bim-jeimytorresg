/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        int op, tipo;

        System.out.println("Cuantos locales desea ingresar: ");
        op = sc.nextInt();

        for (int i = 0; i < op; i++) {
            System.out.println("[1] Local Comida");
            System.out.println("[2] Local Comercial");
            System.out.println("[3] Local Sesiones");
            tipo = sc.nextInt();
            
            if (tipo == 1) {
                sc.nextLine();
                System.out.println("Ingrese el nombre: ");
                String n = sc.nextLine();
                System.out.println("Ingrese la cuota Base");
                double cb = sc.nextDouble();
                System.out.println("Ingrese el iva");
                double iva = sc.nextDouble();
                System.out.println("Ingrese el valor del agua");
                double agua = sc.nextDouble();
                System.out.println("Ingrese el valor de la luz");
                double luz = sc.nextDouble();

                ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                        n, cb);
                arriendoComida.establecerIva(iva); // en porcentaje
                arriendoComida.establecerValorAgua(agua); // en $
                arriendoComida.establecerValorLuz(luz); // en $
                listaArriendos.add(arriendoComida);
            } else if (tipo == 2) {
                sc.nextLine();
                System.out.println("Ingrese el nombre: ");
                String n = sc.nextLine();
                System.out.println("Ingrese la cuota Base");
                double cb = sc.nextDouble();
                System.out.println("Ingrese el valor adicional fijo");
                double valor = sc.nextDouble();

                ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                        n, cb);
                arriendoComercial.establecerValorAdicionalFijo(valor); // en $
                listaArriendos.add(arriendoComercial);
            } else if (tipo == 3) {
                sc.nextLine();
                System.out.println("Ingrese el nombre: ");
                String n = sc.nextLine();
                System.out.println("Ingrese la cuota Base");
                double cb = sc.nextDouble();
                System.out.println("Ingrese el valor de las sillas");
                double sillas = sc.nextDouble();
                System.out.println("Ingrese el valor del la amplificacion");
                double amp = sc.nextDouble();

                ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                        n, cb);
                arriendoSesiones.establecerValorSillas(sillas); // en $
                arriendoSesiones.establecerValorAmplificacion(amp); // en $
                listaArriendos.add(arriendoSesiones);
            } else {
                System.out.println("Opcion Invalida");
            }
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
