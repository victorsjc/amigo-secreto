package br.com.amigosecreto.model.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nilhcem.fakesmtp.FakeSMTP;

import br.com.amigosecreto.model.util.HibernateUtil;

public class PessoaCrud {
	
	public void salvar(Pessoa pessoa){
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(pessoa);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println("excessão ao salvar a pessoa");
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch (Throwable e) {
				System.out.println("excessão ao fechar sessão para salvar");
			}
		}
		
	}
	
	public List<Pessoa> listar(){
		Session session = null;
		Transaction transaction = null;
		Query consulta = null;
		List<Pessoa> resultado = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			consulta = session.createQuery("from Pessoa");
			resultado = consulta.list();
			transaction.commit();
			return resultado;
		} catch (Exception e) {
			System.out.println("excessão ao selecionar contatos");
			throw new HibernateException(e);
		} finally {
			try {
				session.close();
			} catch (Exception e2) {
				System.out.println("excessão ao fechar consulta");
			}
		}
	}
	
	public Pessoa buscarPorId(int id){
		Pessoa pessoa = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from Pessoa where id = :id");
			query.setInteger("id", id);
			pessoa = (Pessoa) query.uniqueResult();
			transaction.commit();
			return pessoa;
		} catch (HibernateException e) {
			System.out.println("Não foi possível buscar a pessoa");
		} finally {
			try {
				session.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de buscar");
			}
		}
		return pessoa;
	}
	
	public Pessoa buscarPorNome(String nome){
		Pessoa pessoa = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from Pessoa where nome = :nome");
			query.setString("nome", nome);
			pessoa = (Pessoa) query.uniqueResult();
			transaction.commit();
			return pessoa;
		} catch (HibernateException e) {
			System.out.println("Não foi possível buscar a pessoa");
		} finally {
			try {
				session.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de buscar");
			}
		}
		return pessoa;
	}
	
	public void atualizarPessoa(Pessoa pessoa){
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(pessoa);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println("Excessão ao atualizar pessoa");
		} finally {
			try {
				session.close();
			} catch (Throwable e) {
				System.out.println("Excessao au fechar operacao de atualizacao");
			}
		}
	}
	
}
