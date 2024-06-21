package com.mycompany.calcetinesauditoria2;
        
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) throws IOException {
 
        Scanner scan = new Scanner(System.in);
        int Nivel; //1=(Administrador) 2(Asistente) 3(Vendedor)
        Gestor a = new Gestor();
        
        String textoAuditoria;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        textoAuditoria =("\nUn usuario ha accedido al sistema: "+dtf.format(LocalDateTime.now())+"\n");
        System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        
        System.out.print("Hola! Introduce tu nombre\n" );
        System.out.println(a.leerNombres("Usuarios.txt"));
        String nombre = scan.nextLine();
        System.out.print("Hola " + nombre +"\n");
        Nivel =(a.Nivel("Usuarios.txt",nombre));
        
        textoAuditoria = ("\n El usuario: " + nombre + " con nivel " + Nivel + " es quien ha accedido al sistema.\n");
        a.Registrar("Auditoria.txt",textoAuditoria);
        
        System.out.print("\nTienes nivel: " + Nivel +"\n");

        if( Nivel == 1 ) {
            MenuAdministrador ma = new MenuAdministrador();
            ma.menuAdmin(nombre);
        }
        if( Nivel == 2 ) {
            MenuAsistente ms = new MenuAsistente();
            ms.menuAsistente(nombre);
        }
        if( Nivel == 3 ) {
            MenuVendedor mv = new MenuVendedor();
            mv.menuVendedor(nombre);
        }

    } // MAIN
    
} // CLASS