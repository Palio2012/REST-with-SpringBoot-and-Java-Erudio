package br.com.erudio.Application.model.MathServices;

import br.com.erudio.Application.model.Exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import static br.com.erudio.Application.model.Converters.NumberConverter.covertToDouble;
import static br.com.erudio.Application.model.Converters.NumberConverter.isNumeric;

@Service
public class MathService {

    public Double sum(String numberOne,String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }
    public Double subtraction(String numberOne,String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }
    public Double multiplication(String numberOne, String numberTwo)  {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }
    public Double division(String numberOne,String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo)  {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (covertToDouble(numberOne) + covertToDouble(numberTwo))/ 2;
    }
    public Double squareroot(String numberOne){
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(covertToDouble(numberOne));
    }
}
