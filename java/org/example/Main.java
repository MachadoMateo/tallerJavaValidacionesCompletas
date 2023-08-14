package org.example;

import org.example.modelos.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado= new Scanner(System.in);
        Usuario objetoUsuario = new Usuario();

        System.out.print("Digite sus nombres y apellidos");
        objetoUsuario.setNombre(teclado.nextLine());

        System.out.println("Su nombre es: "+objetoUsuario.getNombre());
    }
}