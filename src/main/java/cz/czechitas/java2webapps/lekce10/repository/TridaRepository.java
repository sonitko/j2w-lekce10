package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 */
@Repository
public interface TridaRepository  extends JpaRepository<Trida, Short> {

    Optional<Trida> findById(short id);
}
