package it.polito.tdp.yelp.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	Graph<Review, DefaultWeightedEdge> grafo;
	YelpDao dao;
	Map<String, Review> mappaReviews;
	
	
	public Model() {
		dao = new YelpDao();
		mappaReviews = new HashMap<>();
		this.dao.getAllReviews(mappaReviews);
	}
	
	public void creaGrafo(Business business) {
		grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		
		//vertici
		Graphs.addAllVertices(this.grafo, this.dao.getReviewByBusiness(business));
		
		
		//archi
		for(Adiacenza a : this.dao.getAdiacenze(business, mappaReviews)) {
			if(a.getDatar1().compareTo(a.getDatar2())<0) {
				//r1 viene prima di r2
				double peso = (double)(ChronoUnit.DAYS.between(a.getDatar1(), a.getDatar2())); 
				Graphs.addEdgeWithVertices(this.grafo, a.getR1(), a.getR2(), peso);
				//System.out.println("R1->R2"+a.getR1()+" - "+a.getR2()+" - "+peso);
			}
			else{
				//r2 viene prima di r1
				double peso = (double)(ChronoUnit.DAYS.between(a.getDatar2(), a.getDatar1()));
				Graphs.addEdgeWithVertices(this.grafo, a.getR2(), a.getR1(), peso);
				//System.out.println("R2->R1"+a.getR2()+" - "+a.getR1()+" - "+peso);
			}

		}
	}
	
	public List<Trovato> getRecensioneMax() {
		List<Trovato> listaReturn = new ArrayList<>();
		
		int max = 0;
		for(Review r : this.grafo.vertexSet()) {
			List<DefaultWeightedEdge> listaArchiUscenti = new ArrayList<>(this.grafo.outgoingEdgesOf(r));
			if(listaArchiUscenti.size()>max) {
				max = listaArchiUscenti.size();
			}
		}
		
		for(Review r : this.grafo.vertexSet()) {
			if(this.grafo.outgoingEdgesOf(r).size()==max) {
				//ho trovato il vertice con lista archi uscenti max
				Trovato t = new Trovato(r.getReviewId(), this.grafo.outgoingEdgesOf(r).size());
				listaReturn.add(t);
			}
		}
		
		return listaReturn;
	}
	
	public List<Review> getVertici(){
		List<Review> listaV = new ArrayList<>(this.grafo.vertexSet());
		return listaV;
	}
	public List<DefaultWeightedEdge> getArchi(){
		List<DefaultWeightedEdge> listaA = new ArrayList<>(this.grafo.edgeSet());
		return listaA;
	}
	public List<String> getCities(){
		return this.dao.getAllCities();
	}
	public List<Business> getBusiness(String city){
		List<Business> listaTemp = this.dao.getTuttiBusinesses(city);
		Collections.sort(listaTemp);
		return listaTemp;
	}
	
}

