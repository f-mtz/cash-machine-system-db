package com.fmtz.bank.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int accountNumber;
	
//	@JoinColumn(name = "cliente_id")
//	@OneToOne(mappedBy = "cliente")
//	private Cliente cliente;
	public Conta contaOutra;
	private double saldo;
	
	private int qtdgetSaques;
	private int qtdDepositos;
	private int qtdTransferencias;
	
	private double limitgetSaque;
	
	//private List<Transactions> transactions = new ArrayList<>();

	public Conta(Long id, int numeroDaConta /**,Cliente cliente*/, double saldo, double limitgetSaque) {
		this.id = id;
		this.accountNumber = numeroDaConta;
//		this.cliente = cliente;
		this.saldo = saldo;
		this.limitgetSaque = limitgetSaque;
		}
	
	public Long getId() {
		return id;
	}
	
	public Conta getConta() {
		return contaOutra;
	}

	public int getQtdgetSaques() {
		return qtdgetSaques;
	}

	public int getQtdDepositos() {
		return qtdDepositos;
	}

	public int getQtdTransferencias() {
		return qtdTransferencias;
	}

	public double getLimitgetSaque() {
		return limitgetSaque;
	}

	

	public int getAccountNumber() {
		return accountNumber;
	}

//	public Cliente getCliente() {
//		return cliente;
//	}

	public double getSaldo() {
		return saldo;
	}
	
	
	
//	public List<Transactions> getTransactions() {
//		return transactions;
//	}
	
	
	
	public void setContaOutra(Conta contaOutra) {
		this.contaOutra = contaOutra;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public void setQtdgetSaques(int qtdgetSaques) {
		this.qtdgetSaques = qtdgetSaques;
	}



	public void setQtdDepositos(int qtdDepositos) {
		this.qtdDepositos = qtdDepositos;
	}



	public void setQtdTransferencias(int qtdTransferencias) {
		this.qtdTransferencias = qtdTransferencias;
	}



	public void setLimitgetSaque(double limitgetSaque) {
		this.limitgetSaque = limitgetSaque;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**SAQUE*/
	public void getSaque(double x) {
		if(x >= saldo && x < (saldo + limitgetSaque) && qtdgetSaques<4) {
			qtdgetSaques++;
			System.out.println("voc� negativou sua contaOutra em " + (saldo - x));
			this.saldo -= x;
		}
		else if(x >= saldo && x < (saldo + limitgetSaque) && qtdgetSaques> 3) {
			qtdgetSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else if (x == 0) {
			System.out.println("N�o houve saque na sua contaOutra");
		}
		else if(x > (saldo+limitgetSaque)) {
			System.out.println("voc� n�o pode sacar o valor: " + x);
		}
		else if(x <= saldo && qtdgetSaques <= 3) {
			qtdgetSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x);
			}
		else if(x < saldo && qtdgetSaques >= 4) {
			qtdgetSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else {
			qtdgetSaques++;
			this.saldo -= (x + 5);
		}
	}
	
	/**SAQUE*/
	public void getSaqueT(double x) {
		if(x >= saldo && x < (saldo + limitgetSaque) && qtdTransferencias<4) {
			qtdTransferencias++;
			System.out.println("voc� negativou sua contaOutra em " + (saldo - x));
			this.saldo -= x;
		}
		else if(x >= saldo && x < (saldo + limitgetSaque) && qtdTransferencias> 3) {
			qtdTransferencias++;
			System.out.println("voc� transferiu: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else if (x == 0) {
			System.out.println("N�o houve saldo transferido: ");
		}
		else if(x > (saldo+limitgetSaque)) {
			System.out.println("voc� n�o pode getTransferir o valor: " + x);
		}
		else if(x <= saldo && qtdTransferencias <= 3) {
			qtdTransferencias++;
			System.out.println("voc� transferiu: " + (x) + " reais");
			this.saldo -= (x);
			}
		else if(x < saldo && qtdTransferencias >= 4) {
			qtdTransferencias++;
			System.out.println("voc� transferiu: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else {
			qtdTransferencias++;
			this.saldo -= (x + 5);
		}
	}
	
	/**DEPOSITO*/
	public double getDeposito(double y) {
		if(y > 1000) {
			System.out.println("voc� n�o pode depositar mais que 1000 reais por dia !!!");
		}
		qtdDepositos++;
		return this.saldo += y;
	}
	/**TRANSAFERNCIAS*/
	public void getTransferir(Conta receptora, double valor) {
		this.getSaqueT(valor);
		receptora.getDeposito(valor);
	
	}

//	public double getDeposito(double y) {
//		if(y > 1000) {
//			System.out.println("você não pode depositar mais que 1000 reais por dia !!!");
//		}
//		else {
//			qtdDepositos++;		}
//		return saldo +=y;	
//	}
	
}