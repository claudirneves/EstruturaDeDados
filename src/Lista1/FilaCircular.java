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
public class FilaCircular {

    Scanner entrada = new Scanner(System.in);
    public tipoNo cabeca;

    /**
     */
    public void imprime() {
        System.out.println("Impressao: ");
        if (cabeca != null) {
            tipoNo aux = cabeca;
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
            while (aux != cabeca) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
            System.out.println("");
        } else {
            System.out.println("Fila vazia");
        }

    }

    public void insereFinal(int info) {
        if (cabeca == null) {
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(cabeca);

        } else {
            tipoNo aux, novo = null;
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(cabeca);
            aux = cabeca;
            while (aux.getProx() != cabeca) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
        }

        System.out.println(
                "Elemento " + info + " inserido com sucesso! ");
    }

    public void removeInicio() {
        if (cabeca != null) {
            if (cabeca.getProx() == cabeca) {
                cabeca = null;
            } else {
                tipoNo aux = cabeca;
                int valor = cabeca.getInfo();
                while (aux.getProx() != cabeca) {
                    aux = aux.getProx();
                }
                aux.setProx(cabeca.getProx());
                cabeca = cabeca.getProx();

                System.out.println("Elemento " + valor + " removido com sucesso! ");
            }
        } else {
            System.out.println("Fila Vazia");
        }
    }

    public void insereInicio(int info) {
        tipoNo novo, aux;
        if (cabeca == null) {
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(cabeca);
        } else {
            aux = cabeca;
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(cabeca);
            cabeca.setProx(aux.getProx());
            cabeca = novo;
            
        }
    }

    public void menu() {
        int valor, opcao = 0, n;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            System.out.printf("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Remove n-esimo\n(-1) Sair \nOpcao: ");
            opcao = entrada.nextInt();
            switch (opcao) {

                case 1: //insereInicio
                    System.out.printf("Valor: ");
                    valor = entrada.nextInt();
                    insereInicio(valor);
                    break;

                case 2: //insereFinal
                    System.out.printf("Valor: ");
                    valor = entrada.nextInt();
                    insereFinal(valor);
                    break;

                case 3: //removeInicio
                    removeInicio();
                    break;
               
               /* case 4: //removeFinal
                    removeFinal();
                    break;*/

                case 5: //imprime
                    imprime();
                    break;
                  /* case 6: //removenesimo
                    System.out.print("Digite o n-esimo:");
                    n = entrada.nextInt();
                    removenesimo(n);
                    break;  */
                case -1: //sair
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }

    public static void main(String[] args) {
        System.out.println("\n************ Lista Encadeada Dinâmica ************\n");
        FilaCircular filacircular = new FilaCircular();
        filacircular.menu();
        System.out.println("\n************ Fim programa ************\n");
    }

}
