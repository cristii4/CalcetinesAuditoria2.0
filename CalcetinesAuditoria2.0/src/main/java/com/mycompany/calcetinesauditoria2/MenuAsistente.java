package com.mycompany.calcetinesauditoria2;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MenuAsistente {
    
    public void menuAsistente(String nombre) throws IOException {
        Scanner sc = new Scanner(System.in);
        Gestor a = new Gestor();
        int op;
        String textoAuditoria;
        
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1- Listar productos");
            System.out.println("2- Agregar producto");
            System.out.println("3- Modificar venta");
            System.out.println("4- Activar/Desactivar producto");
            System.out.println("5- Crear venta");
            System.out.println("0- Salir");
            op = sc.nextInt();
            
            //Para quitar el salto de linea
            sc.nextLine();
            switch(op) {
                case 1: { // Listar productos
                    textoAuditoria =(nombre + " ha accedido con la opción 'Listar productos'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    System.out.println(a.leer("Productos.txt"));
                    break;
                }
                case 2: { // Agregar producto
                    textoAuditoria =(nombre + " ha accedido con la opción 'Agregar producto'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    String estampado = "";
                    String color = "";
                    int precio;
                    String activo = "";
                    System.out.print("Introduce el estampado del calcetin: ");
                    estampado = sc.nextLine();
                    System.out.print("Introduce el color del calcetin: ");
                    color = sc.nextLine();
                    System.out.print("Introduce el precio del calcetin: ");
                    precio = Integer.parseInt(sc.nextLine());
                    System.out.print("¿Se encuentra activo? Si / No");
                    activo = sc.nextLine();

                    Random r = new Random();
                    int idProducto = r.nextInt(9000) + 1000;

                    String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
                    System.out.print("El producto: ");
                    System.out.println(a.Agregar("Productos.txt",nuevo));
                    System.out.print(" ha sido creado.\n");
                    
                    textoAuditoria =(nombre + " ha agregado el producto: " + nuevo + " a 'Productos.txt'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    
                    break;
                }
                case 3: { // Modificar venta
                    textoAuditoria =(nombre + " ha accedido con la opción 'Modificar venta'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    System.out.print("\nIntroduce el identificador de la venta que deseas modificar: \n");
                    System.out.println(a.leer("Ventas.txt"));
                    int idVenta;
                    idVenta = Integer.parseInt(sc.nextLine());

                    System.out.print("¿Como deseas modificarla?\n");

                    System.out.print("¿Quieres cambiar el nombre? Si / No\n");
                    String cambiarNombre = sc.nextLine();
                    String nombreAntiguo = "";
                    String nombreNuevo = "";
                    String productoAntiguo = "";
                    String productoNuevo = "";

                    if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                        nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                        System.out.print("Introduce el nuevo nombre: ");
                        nombreNuevo = sc.nextLine();
                    } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                        nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                        nombreNuevo = nombreAntiguo;
                    }

                    System.out.print("¿Quieres cambiar el producto? Si / No\n");
                    String cambiarCalcetin = sc.nextLine();
                    String calcetinNuevo = "";
                    if( cambiarCalcetin.equals("si") || cambiarCalcetin.equals("Si") ) {
                        productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                        System.out.print("Introduce el nuevo producto: ");
                        productoNuevo = sc.nextLine();
                    } else if ( cambiarCalcetin.equals("no") || cambiarCalcetin.equals("No") ) {
                        productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                        productoNuevo = productoAntiguo;
                    }

                    String antiguo = "";
                    String nuevo = "";

                    antiguo = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
                    nuevo = idVenta + ";" + nombreNuevo + ";" + productoNuevo;

                    System.out.print("La venta: ' " + antiguo + " ' ha sido modificada a:");
                    System.out.println(a.Modificar("Ventas.txt",antiguo,nuevo));
                    
                    textoAuditoria =("\n" + nombre + " ha modificado la venta: " + antiguo + " a : " + nuevo +" en el archivo 'Ventas.txt'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    break;
                }
                case 4: { // Desactivar producto
                    textoAuditoria =(nombre + " ha accedido con la opción 'Activar/Desactivar producto'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    System.out.print("\nIntroduce el identificador del producto: \n");
                    System.out.println(a.leer("Productos.txt"));
                    int idProducto = Integer.parseInt(sc.nextLine());

                    String estampado = "";
                    String color = "";
                    String precio = "";
                    String activo = "";

                    estampado =  a.leerVentas("Productos.txt",idProducto,1);
                    color =  a.leerVentas("Productos.txt",idProducto,2);
                    precio =  a.leerVentas("Productos.txt",idProducto,3);
                    activo =  a.leerVentas("Productos.txt",idProducto,4);

                    String antiguo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;

                    if( activo.equals("si") || activo.equals("Si") ) {
                        System.out.print("El producto se encuentra: " + activo + "\n"); // activado
                        System.out.print("¿Quieres desactivarlo? Si / No ");
                        String ActivoNuevo = sc.nextLine();
                        if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                            activo = "No";
                        } else {
                            activo = "Si";
                        }

                    } else {
                        System.out.print("El producto se encuentra: " + activo + "\n"); // desactivado
                        System.out.print("¿Quieres activarlo? Si / No ");
                        String ActivoNuevo = sc.nextLine();
                        if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                            activo = "Si";
                        } else {
                            activo = "No";
                        }
                    }
                        String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;

                        System.out.print("El estado del producto: ");
                        System.out.println(a.Modificar("Productos.txt",antiguo,nuevo));
                        System.out.print(" ha sido modoficado."); 
                        
                        textoAuditoria =("\n" + nombre + " ha cambiado la disponibilidad del producto: " + idProducto + " en 'Productos.txt'\n");
                        a.Registrar("Auditoria.txt",textoAuditoria);
                        break;
                }
                case 5: { // Crear venta
                    textoAuditoria =(nombre + " ha accedido con la opción 'Crear venta'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    System.out.print("\nIntroduce el nombre del comprador: \n");
                    String nombreComprador = sc.nextLine();

                    System.out.print("\nIntroduce el estampado del producto: \n");
                    String estampadoProducto = sc.nextLine();

                    Random r = new Random();
                    int idVenta = r.nextInt(9000) + 1000;

                    String nuevo = idVenta + ";" + nombreComprador + ";" + estampadoProducto;
                    System.out.print("La venta: ");
                    System.out.println(a.Agregar("Ventas.txt",nuevo));
                    System.out.print(" ha sido creada.");
                    
                    textoAuditoria =("\n" + nombre + " ha creado la venta: " + nuevo + " en 'Ventas.txt'\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    break;
                }
                case 0: { // Salir
                    textoAuditoria =(nombre + " ha accedido y ha salido\n");
                    a.Registrar("Auditoria.txt",textoAuditoria);
                    break;
                }

                default:{
                    System.out.println("Introduzca una opcion valida");
                }
            }
        } while (op != 0);
    }
    
} // CLASS