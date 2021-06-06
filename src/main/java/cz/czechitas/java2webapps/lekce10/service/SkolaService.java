package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkolaService {

    private final TridaRepository tridaRepository;
    private final UcitelRepository ucitelRepository;
    private final StudentRepository studentRepository;
    private final RodicRepository rodicRepository;

    @Autowired
    public SkolaService(TridaRepository tridaRepository, UcitelRepository ucitelRepository, StudentRepository studentRepository, RodicRepository rodicRepository) {
        this.tridaRepository = tridaRepository;
        this.ucitelRepository = ucitelRepository;
        this.studentRepository = studentRepository;
        this.rodicRepository = rodicRepository;
    }

    public Page<Trida> seznamTrid(Pageable pageable) {
        return tridaRepository.findAll(Pageable.unpaged());
    }

    public Page<Trida> findTridaById(short id, Pageable pageable) {
        return tridaRepository.findById(id, Pageable.unpaged());
    }

    public Page<Rodic> seznamRodicuStudenta(Integer id, Pageable pageable) {
        return rodicRepository.findByDetiIdOrderByPrijmeni(id,Pageable.unpaged());
    }

    public Page<Student> seznamStudentuTridy(short id, Pageable pageable) {
        return studentRepository.findStudentByTridaIdOrderByPrijmeni(id, Pageable.unpaged());
    }

    public Page<Student> findStudentById(Integer id, Pageable pageable) {
        return studentRepository.findById(id, Pageable.unpaged());
    }

}
