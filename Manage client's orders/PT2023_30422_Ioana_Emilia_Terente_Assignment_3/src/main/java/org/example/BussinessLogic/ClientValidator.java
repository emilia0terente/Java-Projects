package org.example.BussinessLogic;

public class ClientValidator {
    public ClientValidator(){
    }

    public boolean ValidateName(String name){
        if(name==""){
           return false;
        }else if(name.matches("[a-zA-Z]+")==false){
            return false;
        }else{
            return true;
        }
    }
    public boolean ValidatePhone(String phoneNumber){
        if(phoneNumber.length()!=10){
            return false;
        }else if(phoneNumber.matches("[0-9]+")==false){
            return false;
        }else{
            return true;
        }
    }
    public boolean ValidateEmail(String email){
        if(email.contains("@")==false || email.contains(".")==false){
            return false;
        }else{
            return true;
        }
    }

    public boolean ValidateClient(String name,String phoneNumber, String email){
        if(ValidateName(name)==false){
            return false;
        }else if(ValidatePhone(phoneNumber)==false){
            return false;
        }else if(ValidateEmail(email)==false){
            return false;
        }else{
            return true;
        }
    }
}
