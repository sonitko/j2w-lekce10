package cz.czechitas.java2webapps.lekce9.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Entita pro data o jednom studentovi.
 */
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, length = 100)
  private String krestniJmeno;

  @NotBlank
  @Column(nullable = false, length = 100)
  private String prijmeni;

  @NotNull
  @Column(nullable = false, length = 10)
  private String rodneCislo;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "trida_id")
  private Trida trida;

  @NotEmpty
  @ManyToMany
  @OrderBy("prijmeni, krestniJmeno")
  @JoinTable(
          name = "rodice_deti",
          joinColumns = @JoinColumn(name = "student_id"),
          inverseJoinColumns = @JoinColumn(name = "rodic_id"))
  private List<Rodic> rodice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getKrestniJmeno() {
    return krestniJmeno;
  }

  public void setKrestniJmeno(String krestniJmeno) {
    this.krestniJmeno = krestniJmeno;
  }

  public String getPrijmeni() {
    return prijmeni;
  }

  public void setPrijmeni(String prijmeni) {
    this.prijmeni = prijmeni;
  }

  public String getRodneCislo() {
    return rodneCislo;
  }

  public void setRodneCislo(String rodneCislo) {
    this.rodneCislo = rodneCislo;
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
}
