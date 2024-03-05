package org.example.model;


import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Monomial {
    Double coeff=0.0;
    Integer degree=0;

    public Double getCoeff() {
        return coeff;
    }
    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }
    public Integer getDegree() {
        return degree;
    }
    public void setDegree(Integer degree) {
        this.degree = degree;
    }


    public Monomial(String m){
        char c = m.charAt(0);
        if(c=='-'){
            coeff= -1.0;
        }else if(c=='+'){
            coeff= 1.0;
        }
        if(!m.equals("")){
            if(m.contains("x")){
                Double x=1.0;
                if(m.indexOf("x")!=1){
                    x=Double.parseDouble(m.substring(1,m.indexOf("x")));
                }
                if(m.contains("^")){
                    degree=Integer.parseInt(m.substring(m.indexOf("^")+1));
                }else{
                    degree=1;
                }
                coeff *=x;
            }else{
                degree=0;
                coeff *=Integer.parseInt(m.substring(1));
            }
        }
    }
}
