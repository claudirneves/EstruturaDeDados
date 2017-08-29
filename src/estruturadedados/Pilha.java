/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedados;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Pilha {

    /**
     * @param args the command line arguments
     */
    Scanner entrada = new Scanner(System.in);
    public tipoNo topo;

    public void insere(int info) {
        tipoNo novo;
        if (topo == null) {
            topo = new tipoNo();
            topo.setInfo(info);
            topo.setProx(null);
        } else {
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(topo);
            topo = novo;
        }
    }

    public void remove() {
        if (topo != null) {
            int valor = topo.getInfo();
            System.out.println("Elemento " + valor + " removido com sucesso! ");
            topo = topo.getProx();
        }else{
            System.out.println("Pilha Vazia!");
        }
    }

    public void imprime() {
        if (topo != null) {
            tipoNo aux = topo;
            System.out.println("Impressao: ");
            while (aux != null) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
            System.out.println("");
        } else {
            System.out.println("Pilha vazia!");
        }
    }

    public void menu() {
        int valor, opcao = 0;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            System.out.printf("\nDigite a opcao: \n(1) Insere Inicio \n(2) Remove Inicio \n(3) Imprime \n(-1) Sair \nOpcao: ");
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
        System.out.println("\n************ Lista Encadeada Dinâmica ************\n");
        Pilha P = new Pilha();
        P.menu();
        System.out.println("\n************ Fim programa ************\n");
    }

}
