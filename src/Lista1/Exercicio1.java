/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista1;

import estruturadedados.tipoNo;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    Scanner entrada = new Scanner(System.in);
    public tipoNo cabeca;
    int escolha;
   

    public void insere(int info) {
        tipoNo aux, novo;
        aux = cabeca;
        novo = new tipoNo();
        novo.setInfo(info);
        novo.setProx(aux);
        cabeca = novo;

    }

    public void remove() {
        System.out.print("Qual termo deseja remover: ");
        escolha = entrada.nextInt();
        tipoNo aux;
        if (cabeca != null) {
            aux = cabeca;
            while (aux.getProx()!=null) {
                aux = aux.getProx();
                
                    aux.setProx(null);
                   
               
            }
            System.out.println("Elemento removido");
        } else {
            System.out.println("Fila vazia!");
        }
    }

    public void imprime() {
        if (cabeca != null) {
            tipoNo aux = cabeca;
            System.out.println("Impressao: ");
            while (aux != null) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
            System.out.println("");
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public void menu() {
        int valor, opcao = 0;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            System.out.printf("\nDigite a opcao: \n(1) Insere \n(2) Remove \n(3) Imprime \n(-1) Sair \nOpcao: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1: //insere
                    System.out.printf("Valor: ");
                    valor = entrada.nextInt();
                    insere(valor);
                    break;

                case 2: //remove
                    remove();
                    break;

                case 3: //imprime
                    imprime();
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }

    public static void main(String[] args) {
        //Fazer a remoção do nésimo termo de uma lista encadeada simples
        System.out.println("\n************ Lista Encadeada Dinâmica ************\n");
        Exercicio1 exer = new Exercicio1();
        exer.menu();
        System.out.println("\n************ Fim programa ************\n");
    }

}
