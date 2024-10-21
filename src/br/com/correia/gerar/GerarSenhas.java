/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.correia.gerar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fe_li
 */
public class GerarSenhas {

    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()_+-={}:<>?,./";

    

    public String gerarSenha(int tamanho, boolean mai, boolean minus, boolean num, boolean esp) {
        String tiposCaracteres = "";
        StringBuilder senha = new StringBuilder();
        Random random = new Random();

        // incluir pelo menos um caractere de cada tipo
        if(mai){
            senha.append(getCaractereAleatorio(LETRAS_MAIUSCULAS, random));
            tiposCaracteres += LETRAS_MAIUSCULAS;
        }         
        if(minus){
            senha.append(getCaractereAleatorio(LETRAS_MINUSCULAS, random));
            tiposCaracteres += LETRAS_MINUSCULAS;
        }        
        if(num){
            senha.append(getCaractereAleatorio(NUMEROS, random));
            tiposCaracteres += NUMEROS;
        }        
        if(esp){
            senha.append(getCaractereAleatorio(CARACTERES_ESPECIAIS, random));
            tiposCaracteres += CARACTERES_ESPECIAIS;
        }     

        // preencher o restante da senha com caracteres aleatórios
        for (int i = 0; i < tamanho-1; i++) {
            senha.append(getCaractereAleatorio(tiposCaracteres.toString(), random));
        }

        return senha.toString();
    }

    private static String getCaractereAleatorio(String tipoCaractere, Random random) {
        return String.valueOf(tipoCaractere.charAt(random.nextInt(tipoCaractere.length())));
    }

}
