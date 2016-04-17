package org.develnotes.examples;

public class Operation {
    double number1;
    double number2;
    double result;
    int operation;    
    String error;
    
    public double getNumber1() {
        return number1;
    }
    public double getNumber2() {
        return number2;
    }
    public void setNumber1(double number1) {
        this.number1 = number1;
    }
    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public int getOperation() {
        return operation;
    }
    public void setOperation(int operation) {
        this.operation = operation;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;        
    }
    public String getError() {
           return error;
    }
    public void setError(String error) {
           this.error = error;        
    }   
    @Override
    public String toString() {
        return String.format("{number1:%s, number2:%s,result:%s,operation:%s,error:%s}", number1, number2,result,operation,error);
    }
}
