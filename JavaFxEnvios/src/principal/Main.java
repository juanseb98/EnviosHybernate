package principal;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;

import Objetos.Camion;
import Objetos.Camionero;
import Objetos.Reparto;
import Objetos.TipoCamion;
import ajustesHibernate.HibernateUtil;
import dao.GenericDAO;


public class Main {
	private static Scanner teclado = new Scanner(System.in);
	private static Session session;
	private static GenericDAO genericDAO = new GenericDAO<>();

	public static void main(String[] args) {
		configurarSesion();
		try {
			Camionero cam = new Camionero("20503879T", "Juan", "Sevilla", 697366754, 1400.0);
			Camion cami = new Camion("123jdk", "Mercedes", 25.0, TipoCamion.Diesel);
			Date fecha = new Date();
			Reparto rep = new Reparto(1, cami, cam, fecha);
			
			//genericDAO.guardar(cami);
			
			genericDAO.guardar(rep);
			
			System.out.println(" se guardo reparto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void cerrarSesion() {
		HibernateUtil.closeSessionFactory();
	}

	private static void configurarSesion() {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSessionAndBindToThread();
		session = HibernateUtil.getSessionFactory().getCurrentSession();

	}
}