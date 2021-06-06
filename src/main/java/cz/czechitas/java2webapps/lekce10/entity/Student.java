package cz.czechitas.java2webapps.lekce10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String jmeno;
  private String prijmeni;

  @ManyToOne
  private Trida trida;

  public Integer getId() {
    return id;
  }

  @ManyToMany(mappedBy = "deti")
  @OrderBy("prijmeni, jmeno")
  private List<Rodic> rodice;

  public void setId(Integer id) {
    this.id = id;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public String getPrijmeni() {
    return prijmeni;
  }

  public void setPrijmeni(String prijmeni) {
    this.prijmeni = prijmeni;
  }

  public Trida getTrida() {
    return trida;
  }

  public void setTrida(Trida trida) {
    this.trida = trida;
  }

  public List<Rodic> getRodice() {
    return rodice;
  }

  public void setRodice(List<Rodic> rodice) {
    this.rodice = rodice;
  }

  @Override
  public String toString() {
    return String.format("%s %s [%d]", prijmeni, jmeno, id);
  }
}
