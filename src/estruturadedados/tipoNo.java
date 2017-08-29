/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedados;

/**
 *
 * @author aluno
 */
public class tipoNo{
	public int info;
	public tipoNo prox;
	
	public tipoNo(){}
	
	public void setInfo(int info){
		this.info=info;
	}

	public void setProx(tipoNo prox){
		this.prox=prox;
	}
	
	public int getInfo(){
		return info;
	}
	public tipoNo getProx(){
		return prox;
	}
	
}
