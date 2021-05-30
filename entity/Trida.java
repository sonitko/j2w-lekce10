package cz.czechitas.java2webapps.lekce9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Entita s údaji o jedné třídě (skupině žáků).
 */
@Entity
public class Trida {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @NotNull
  @Column(nullable = false, unique = true, length = 4)
  private String nazev;

  @NotEmpty
  @OneToMany(mappedBy = "trida")
  @OrderBy("prijmeni, krestniJmeno")
  private List<Student> studenti;

  @NotNull
  @OneToOne(mappedBy = "trida", optional = false)
  private Ucitel tridniUcitel;

  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    this.nazev = nazev;
  }

  public List<Student> getStudenti() {
    return studenti;
  }

  public void setStudenti(List<Student> studenti) {
    this.studenti = studenti;
  }

  public Ucitel getTridniUcitel() {
    return tridniUcitel;
  }

  public void setTridniUcitel(Ucitel tridniUcitel) {
    this.tridniUcitel = tridniUcitel;
  }
}
