package com.example.correct.Easy.core.domain.vo;

import com.example.correct.Easy.core.exceptions.DomainException;

public class FullName{
    private String fullName;

    public FullName(String firstName,String lastName){
     validateFirstName(firstName);
     validateLastName(lastName);
     this.fullName=generateFullName(firstName,lastName);
    }

    public FullName(String fullName){
        this.fullName=fullName;
    }

    public String getFullName(){return this.fullName;}

    private String generateFullName(String firstName,String lastName){
        return capitalizeName(firstName)+" "+capitalizeName(lastName);
    }

    private void validateFirstName(String firstName){
        if (firstName==null){throw new DomainException("o firstName não pode ser nulo.");}

        if (firstName.isEmpty()){throw new DomainException("o firstName não pode ser vazio.");}

        if (firstName.length()<3||firstName.length()>23){throw new DomainException("o número de caracteres aceitos num nome são de 3 até 23.");}
    }

    private void validateLastName(String lastName){
        if (lastName==null){throw new RuntimeException("error");}

        if (lastName.isEmpty()){throw new RuntimeException("error");}

        if (lastName.length()<3||lastName.length()>23){throw new RuntimeException("error");}
    }

    private String capitalizeName(String name){
        String[] nameSplited=name.split(" ");
        StringBuilder builder=new StringBuilder();
        for(String n:nameSplited){
            String nameCapitalized=n.substring(0,1).toUpperCase()+n.substring(1).toLowerCase();
            builder.append(nameCapitalized+" ");
        }

        return builder.toString().trim();
    }
}
