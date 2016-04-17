package org.develnotes.examples;
public class Model {
    public Operation calc(Double number1, Double number2, int operation, String error) {
        double res = 0;
        Operation object = new Operation();
        object.setNumber1(number1);
        object.setNumber2(number2);
        object.setOperation(operation);
        object.setError(error);
        object.setResult(res);
        try {
            Type type = Type.values()[operation];
            switch (type) {
                case DIV:
                    if (number2 == 0.0) {
                        error = "+";                          
                        break;
                    } else {
                        error = "OK";
                        res = number1 / number2;
                        break;
                    } 
                case PLUS:
                    res = number1 + number2;
                    break;
                case MINUS:
                    res = number1 - number2;
                    break;
                case MUL:
                    res = number1 * number2;
                    break;                              
            }
            object.setError(error);
            object.setResult(res);
        } 
        catch (Exception e) { }
        return object;
    }
}
