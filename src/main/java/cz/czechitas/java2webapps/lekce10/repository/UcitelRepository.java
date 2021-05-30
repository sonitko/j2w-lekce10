package cz.czechitas.java2webapps.lekce9.repository;

import cz.czechitas.java2webapps.lekce9.entity.Rodic;
import cz.czechitas.java2webapps.lekce9.entity.Ucitel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface UcitelRepository extends JpaRepository<Ucitel, Long> {
}
