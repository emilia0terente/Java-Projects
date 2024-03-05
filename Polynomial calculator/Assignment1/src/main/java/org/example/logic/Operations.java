package org.example.logic;

import org.example.model.Polynomial;

import java.util.Objects;

public class Operations {
    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial addition = new Polynomial();
        for(Integer i:polynomial1.poly.keySet()){
            for(Integer j: polynomial2.poly.keySet()){
                if(Objects.equals(i,j)){
                    addition.poly.put(i,polynomial1.poly.get(i)+polynomial2.poly.get(j));
                }
                else{
                    if(!addition.poly.containsKey(i)){
                        addition.poly.put(i,polynomial1.poly.get(i));
                    }
                    if(!addition.poly.containsKey(j)){
                        addition.poly.put(j,polynomial2.poly.get(j));
                    }
                }
            }
        }
        return addition;
    }
    public Polynomial substraction(Polynomial polynomial1,Polynomial polynomial2){
        Polynomial substr=new Polynomial();
        for(Integer i:polynomial2.poly.keySet()){
            substr.poly.put(i,-polynomial2.poly.get(i));
        }
        return add(polynomial1,substr);
    }

    public Polynomial multiply(Polynomial p1,Polynomial p2){
        Polynomial m=new Polynomial();
        for(Integer i:p1.poly.keySet()){
            for(Integer j:p2.poly.keySet()){
                if(m.poly.get(i+j)!=null) {
                    m.poly.put(i+j, p1.poly.get(i)*p2.poly.get(j) + m.poly.get(i));
                }else{
                    m.poly.put(i+j,p1.poly.get(i)*p2.poly.get(j));
                }
            }
        }
        return m;
    }
    public Polynomial integrate(Polynomial p){
        Polynomial i=new Polynomial();
        for(Integer integer:p.poly.keySet()){
            i.poly.put(integer+1,p.poly.get(integer)/(integer+1));
        }
        return i;
    }
    public Polynomial derivate(Polynomial p){
        Polynomial d=new Polynomial();
        for(Integer i:p.poly.keySet()){
            if(i>0){
                d.poly.put(i-1,i*p.poly.get(i));
            }
        }
        return d;
    }
}
