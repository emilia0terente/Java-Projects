package org.example.model;

import java.util.*;

public class Polynomial {
    //define the polynomial using a HashMap as public
    public HashMap<Integer, Double> poly;
    public Polynomial() {
        this.poly = new HashMap<Integer,Double>();
    }
    public HashMap<Integer, Double> getPoly() {
        return poly;
    }
    public void setPoly(HashMap<Integer,Double> poly) {
        this.poly = poly;
    }
    Integer maxDegree;
    public Integer getMaxDegree() {
        return maxDegree;
    }
    public void setMaxDegree(Integer maxDegree) {
        this.maxDegree = maxDegree;
    }
    public void duplicate(Polynomial p1,Polynomial p2){
        for(Integer integer:p2.getPoly().keySet()){
            p1.poly.put(integer,p2.getPoly().get(integer));
        }
    }
    public static void showPolynom(Polynomial p){
        for(Integer i: p.poly.keySet()){
            System.out.println(" degree "+i+" coeff "+ p.poly.get(i));
        }
    }
    public static void markIfAbsent(Polynomial p){
        int i=0;
        while(i<=p.maxDegree){
            if(!p.poly.containsKey(i)){
                p.poly.put(i,0.0);
            }
            i++;
        }
    }

    public static void fromString(String p,Polynomial p1) {//Polynomial
        String[] mono = p.split("(?=[+-])");
        Integer maxD=0;//calculate the maxDegree
        for (String i: mono){
            Monomial monomial = new Monomial(i);
            if(monomial.getDegree()>maxD){
                maxD=monomial.getDegree();
            }
        }
        p1.maxDegree=maxD;
        for(String i:mono){
            Monomial monomial=new Monomial(i);
            p1.poly.put(monomial.getDegree(),monomial.getCoeff());
        }
        Polynomial.markIfAbsent(p1);
    }

    public String hashToString(){
        StringBuilder result=new StringBuilder() ;
        for(Integer i : poly.keySet()){
            if (poly.get(i)!=0) {
                if(poly.get(i)>0){
                    result.append("+");
                }
                result.append(poly.get(i));
                if(i!=0) {
                    if(i==1){
                        result.append("x");
                    }else {
                        result.append("x^");
                        result.append(i);
                    }
                }
            }
            else{
                continue;
            }
        }
        return result.toString();
    }
}
