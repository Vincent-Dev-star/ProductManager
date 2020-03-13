package fr.myschool.productmanager.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@SuppressWarnings("serial")
public class Category implements Serializable{

	@Id
	
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> produit;

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public List<Product> getProduit() {
		return produit;
	}

	public void setProduit(List<Product> produit) {
		this.produit = produit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
