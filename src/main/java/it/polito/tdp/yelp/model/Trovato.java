package it.polito.tdp.yelp.model;

public class Trovato {
	private String review_id;
	private int numeroArchiUscenti;
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public int getNumeroArchiUscenti() {
		return numeroArchiUscenti;
	}
	public void setNumeroArchiUscenti(int numeroArchiUscenti) {
		this.numeroArchiUscenti = numeroArchiUscenti;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroArchiUscenti;
		result = prime * result + ((review_id == null) ? 0 : review_id.hashCode());
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
		Trovato other = (Trovato) obj;
		if (numeroArchiUscenti != other.numeroArchiUscenti)
			return false;
		if (review_id == null) {
			if (other.review_id != null)
				return false;
		} else if (!review_id.equals(other.review_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return review_id + " -> " + numeroArchiUscenti;
	}
	public Trovato(String review_id, int numeroArchiUscenti) {
		super();
		this.review_id = review_id;
		this.numeroArchiUscenti = numeroArchiUscenti;
	}
	
}
