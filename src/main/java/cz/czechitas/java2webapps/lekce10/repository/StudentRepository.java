package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 */
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {

    Page<Student> findStudentiByTridaIdOrderByPrijmeniAscJmenoAsc(short id, Pageable pageable);

    Optional<Student> findById(Integer id);
}

