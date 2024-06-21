package com.mycompany.calcetinesauditoria2;

import java.io.IOException;
import java.util.Scanner;

public class MenuVendedor {
    
    public void menuVendedor(String nombre) throws IOException {
        Scanner sc = new Scanner(System.in);
        Gestor a = new Gestor();
        int op;
        String textoAuditoria;
        
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1- Listar productos");
            System.out.println("0- Salir");
            op = sc.nextInt();
            //Para quitar el salto de linea
            sc.nextLine();
            switch(op) {
                case 1: { 
                    textoAuditoria =(nombre + " ha accedido con la opción 'Listar productos'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    System.out.println(a.leer("Productos.txt"));
                    break;
                }
                case 0: {
                    // Salir
                    textoAuditoria =(nombre + " ha accedido y ha salido\n");
                    break;
                }

                default:{
                    System.out.println("Introduzca una opcion valida");
                }
            }
        } while (op != 0);
    }
    
} // CLASS