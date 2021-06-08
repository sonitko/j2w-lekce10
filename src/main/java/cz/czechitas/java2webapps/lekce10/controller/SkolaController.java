package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkolaController {

    private final SkolaService skolaService;

    public SkolaController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/")
    public ModelAndView seznamTrid(@PageableDefault(sort = {"nazev"}) Pageable pageable) {
        return new ModelAndView("index")
                .addObject("tridy", skolaService.seznamTrid(pageable));
    }

    @GetMapping(path = "/", params = "id")
    public ModelAndView detailTridy(@PageableDefault(sort = {"prijmeni, jmeno"}) short id) {
        ModelAndView result = new ModelAndView("detailTrida");
        result.addObject("seznamStudentu", skolaService.seznamStudentuTridy(id, Pageable.unpaged()));
        result.addObject("trida", skolaService.findTridaById(id));
        return result;
    }

    @GetMapping(path = "/student", params = "id")
    public ModelAndView detailStudenta(@PageableDefault(sort = {"prijmeni, jmeno"}) Integer id) {
        ModelAndView result = new ModelAndView("detailStudent");
        result.addObject("student", skolaService.findStudentById(id));
        result.addObject("rodice", skolaService.seznamRodicuStudenta(id, Pageable.unpaged()));
        return result;
    }

}
