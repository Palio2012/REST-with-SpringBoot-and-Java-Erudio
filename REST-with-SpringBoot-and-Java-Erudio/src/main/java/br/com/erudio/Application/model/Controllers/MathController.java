package br.com.erudio.Application.model.Controllers;

import br.com.erudio.Application.model.MathServices.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {

    private MathService mathService = new MathService();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}" )
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.sum(numberOne, numberTwo);
    }
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}" )
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.subtraction(numberOne, numberTwo);
    }
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}" )
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
        return mathService.multiplication(numberOne, numberTwo);
    }
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}" )
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
        return mathService.division(numberOne, numberTwo);
    }
    @RequestMapping(value = "/average/{numberOne}/{numberTwo}" )
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
        return mathService.average(numberOne, numberTwo);
    }
    @RequestMapping(value = "/squareroot/{numberOne}" )
    public Double squareroot(@PathVariable("numberOne") String numberOne) throws Exception {
        return mathService.squareroot(numberOne);
    }
}