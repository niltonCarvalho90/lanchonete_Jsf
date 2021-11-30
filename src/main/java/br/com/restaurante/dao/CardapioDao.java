package br.com.restaurante.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.restaurante.domain.Cardapio;
import br.com.restaurante.util.JPAUtil;
import br.com.restaurante.util.JSFUtil;

public class CardapioDao {
	
	private EntityManager em;

	public CardapioDao() {
	}
	
	public CardapioDao(EntityManager em) {
		this.em = em;
	}

	public ArrayList<Cardapio> listar() {
		EntityManager em = JPAUtil.getEntityManager();
        this.em = em;

        String jpql = "SELECT p FROM Cardapio p";
        return (ArrayList<Cardapio>) em.createQuery(jpql, Cardapio.class).getResultList();
	}	

	public void cadastrar(Cardapio cardapio) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;
		
		try {
			em.getTransaction().begin();
			this.em.persist(cardapio);
			em.getTransaction().commit();
			em.close();
			
			JSFUtil.adicionarMensagemDeSucesso("Produto cadastrado no cardápio com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
		
	}	
	
	public Integer contar(Cardapio cardapio) {
		Integer contagem = 0;
		
		contagem = listar().size();
		return contagem;		
	}	
	
}
