package br.com.restaurante.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import br.com.restaurante.dao.CardapioDao;
import br.com.restaurante.domain.Cardapio;

@ManagedBean(name = "CardapioBean")
@ViewScoped
public class CardapioBean {
	
	private Cardapio nomeComida = new Cardapio();
	private ArrayList<Cardapio> comboTipoComida;
	private transient ArrayList<Cardapio> itens;
	
	public Cardapio getNomeComida() {
		return nomeComida;
	}
	public void setNomeComida(Cardapio nomeComida) {
		this.nomeComida = nomeComida;
	}
	public ArrayList<Cardapio> getComboTipoComida() {
		return comboTipoComida;
	}
	public void setComboTipoComida(ArrayList<Cardapio> comboComida) {
		this.comboTipoComida = comboComida;
	}
	public ArrayList<Cardapio> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Cardapio> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void mostrarLista() {
		CardapioDao cardapioDao = new CardapioDao();
		itens = cardapioDao.listar();
	}

	@PostConstruct
	public void prepararSalvar(ComponentSystemEvent evento) {
		nomeComida  = new Cardapio();
		
		CardapioDao dao = new CardapioDao();
	}
	
	public void salvar() {
		
		CardapioDao cardapioDao = new CardapioDao();
		cardapioDao.cadastrar(nomeComida);
		
		mostrarLista();
	}
	
}
