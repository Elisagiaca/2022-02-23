package it.polito.tdp.yelp.model;

import java.time.LocalDateTime;

public class Adiacenza {
	private Review r1;
	private Review r2;
	private LocalDateTime datar1;
	private LocalDateTime datar2;
	public Review getR1() {
		return r1;
	}
	public void setR1(Review r1) {
		this.r1 = r1;
	}
	public Review getR2() {
		return r2;
	}
	public void setR2(Review r2) {
		this.r2 = r2;
	}
	public LocalDateTime getDatar1() {
		return datar1;
	}
	public void setDatar1(LocalDateTime datar1) {
		this.datar1 = datar1;
	}
	public LocalDateTime getDatar2() {
		return datar2;
	}
	public void setDatar2(LocalDateTime datar2) {
		this.datar2 = datar2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datar1 == null) ? 0 : datar1.hashCode());
		result = prime * result + ((datar2 == null) ? 0 : datar2.hashCode());
		result = prime * result + ((r1 == null) ? 0 : r1.hashCode());
		result = prime * result + ((r2 == null) ? 0 : r2.hashCode());
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
		Adiacenza other = (Adiacenza) obj;
		if (datar1 == null) {
			if (other.datar1 != null)
				return false;
		} else if (!datar1.equals(other.datar1))
			return false;
		if (datar2 == null) {
			if (other.datar2 != null)
				return false;
		} else if (!datar2.equals(other.datar2))
			return false;
		if (r1 == null) {
			if (other.r1 != null)
				return false;
		} else if (!r1.equals(other.r1))
			return false;
		if (r2 == null) {
			if (other.r2 != null)
				return false;
		} else if (!r2.equals(other.r2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Adiacenza [r1=" + r1 + ", r2=" + r2 + ", datar1=" + datar1 + ", datar2=" + datar2 + "]";
	}
	public Adiacenza(Review r1, Review r2, LocalDateTime datar1, LocalDateTime datar2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
		this.datar1 = datar1;
		this.datar2 = datar2;
	}
	
	
}
