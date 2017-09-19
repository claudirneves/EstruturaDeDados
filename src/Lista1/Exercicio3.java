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
public class Exercicio3 {

    Scanner entrada = new Scanner(System.in);
    public tipoNo cabeca;
    //public tipoNo novaCabeca;

    /**
     * @param args the command line arguments
     */
    Exercicio3() {
        System.out.println("Criando fila...(construtor fila)");
    }
    
    public tipoNo getCabeca(){
        return cabeca;
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

    public void removenesimo(int n) {

        if (cabeca == null) {
            System.out.println("Lista vazia!");
        } else {
            //remocao do primeiro
            int valor;
            if (n == 1) {
                valor = cabeca.getInfo();
                cabeca = cabeca.getProx();
                System.out.println("Valor " + valor + " removido!");
            } else {
                int pos = 1;
                tipoNo aux;
                aux = cabeca;

                while (aux.getProx() != null && pos != n - 1) {
                    aux = aux.getProx();
                    pos++;
                }
                if (aux.getProx() != null) {
                    valor = aux.getProx().getInfo();
                    aux.setProx(aux.getProx().getProx());
                    System.out.println("Valor " + valor + " removido!");
                } else {
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
            } else if (cabeca.getProx().getProx() == null) {
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

    public void dividirLista(int n) {
        if (cabeca != null) {
            int pos = 1;
            tipoNo aux;
            aux = cabeca;
            tipoNo novaCabeca;
            while (pos != n) {
                aux = aux.getProx();
                pos++;
            }
            tipoNo novaAux;
            novaCabeca = aux;
            novaCabeca = novaCabeca.getProx();
            aux.setProx(null);
            novaAux = novaCabeca;
            System.out.println("Nova Lista");
            while (novaAux != null) {
                System.out.print(novaAux.getInfo() + " ");
                novaAux = novaAux.getProx();
            }
        } else if (cabeca.getProx() == null) {
            System.out.println("Lista possui apenas um elemento");
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public void novaLista() {
        Exercicio3 lista2  = new Exercicio3();
        lista2.menu();
    }

    public void concatenarListas(Exercicio3 l2) {
        
       
    }

    public void menu() {
        int valor, opcao = 0, n;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            System.out.printf("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n"
                    + "(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Remove n-esimo\n"
                    + "(7) Dividir Lista\n(8) Concatenar Listas\n(-1) Sair \nOpcao: ");
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
                case 7: //dividiLista
                    System.out.print("Em qual posição deseja dividir a lista? ");
                    n = entrada.nextInt();
                    dividirLista(n);
                    break;
                case 8: //novaLista
                 //   tipoNo
                    Exercicio3 l3 = new Exercicio3();
                    l3.menu();
                    concatenaLista(l3);

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

    public void concatenaLista(Exercicio3 lista2){
        
        tipoNo aux1 = cabeca;
        
        if(aux1==null)
            cabeca = lista2.getCabeca();
        else{
            tipoNo aux2=cabeca;
            
            while(aux2.getProx()!=null)
                aux2=aux2.getProx();
        
            aux2.setProx(lista2.getCabeca());
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("\n************ Lista Encadeada Dinâmica ************\n");
        Exercicio3 lista1 = new Exercicio3();
        //lista1.menu();
        lista1.insereInicio(1);
        lista1.insereInicio(2);
        lista1.insereInicio(3);
        lista1.imprime();
        Exercicio3 lista2 = new Exercicio3();
        lista2.insereInicio(4);
        lista2.insereInicio(5);
        lista2.insereInicio(6);
        lista2.imprime();
        lista1.concatenaLista(lista2);
        lista1.imprime();
        
        //Exercicio3 exerc4 = new Exercicio3();
        //exerc3.menu();
        //exerc3.insereFinal(2);
        //exerc3.concatena(exerc4);
        
        System.out.println("\n************ Fim programa ************\n");
    }

}
