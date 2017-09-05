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
public class Fila {

    Scanner entrada = new Scanner(System.in);
    public tipoNo cabeca;

    Fila() {
        System.out.println("Criando fila...(construtor fila)");
    }

    public void insereFinal(int info) {
        if (cabeca == null) {
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        } else {
            tipoNo aux, novo;

            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
        }

        System.out.println("Elemento " + info + " inserido com sucesso! ");
    }

    public void removeInicio() {
        if (cabeca != null) {
            int valor = cabeca.getInfo();
            System.out.println("Elemento " + valor + " removido com sucesso! ");
            cabeca = cabeca.getProx();
        }
    }

    public void insereInicio(int info) {
        tipoNo novo, aux;
        aux = cabeca;
        novo = new tipoNo();
        novo.setInfo(info);
        novo.setProx(aux);
        cabeca = novo;

    }
    public void removenesimo(int n){
        
            if(cabeca == null){
                System.out.println("Lista vazia!");
            }else{
                //remocao do primeiro
                int valor;
                if(n==1){
                    valor = cabeca.getInfo();
                    cabeca = cabeca.getProx();
                    System.out.println("Valor "+valor+" removido!");
                }else{
                    int pos=1;
                    tipoNo aux;
                    aux = cabeca;
                    
                    while(aux.getProx()!=null && pos != n-1){
                        aux = aux.getProx();
                        pos++;
                    }
                    if(aux.getProx()!=null){
                        valor = aux.getProx().getInfo();
                        aux.setProx(aux.getProx().getProx());
                        System.out.println("Valor "+valor+" removido!");
                    }else{
                        System.out.println("Posicao inexistente!");
                    }
                } 
            
            }
                
        
        }

    public void removeFinal() {
        tipoNo aux;
        if (cabeca != null) {
            if (cabeca.getProx() == null) {
                cabeca = null;
            } else if (cabeca.getProx().getProx()== null) {
                cabeca.prox = null;
            } else {
                aux = cabeca;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                    if (aux.getProx().getProx() == null) {
                        aux.setProx(null);
                        break;
                    }
                }
            }
            System.out.println("Elemento removido");
        } else {
            System.out.println("Fila vazia!");
        }
    }

    public void imprime() {
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }

    public void menu() {
        int valor, opcao = 0,n;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            System.out.printf("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Imprime Terceiro\n(-1) Sair \nOpcao: ");
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

                case 4: //removeFinal
                    removeFinal();
                    break;

                case 5: //imprime
                    imprime();
                    break;
                case 6: //removenesimo
                    System.out.print("Digite o n-esimo:");
                     n = entrada.nextInt();
                     removenesimo(n);
                     break;
                case -1: //sair
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }

    public static void main(String args[]) {
        System.out.println("\n************ Lista Encadeada Dinâmica ************\n");
        Fila F = new Fila();
        F.menu();
        System.out.println("\n************ Fim programa ************\n");
    }
}
