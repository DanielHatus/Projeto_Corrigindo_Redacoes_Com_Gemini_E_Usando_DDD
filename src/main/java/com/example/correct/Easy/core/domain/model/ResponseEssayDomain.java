package com.example.correct.Easy.core.domain.model;

import com.example.correct.Easy.core.exceptions.DomainException;

import java.util.List;

public class ResponseEssayDomain{
    private Long id;
    private String feedback;
    private EssayDomain essayRef;
    private Integer compOne;
    private Integer compTwo;
    private Integer compThree;
    private Integer compFour;
    private Integer compFive;

    public ResponseEssayDomain(String feedback,
                               EssayDomain essayRef,
                               Integer compOne,
                               Integer compTwo,
                               Integer compThree,
                               Integer compFour,
                               Integer compFive){
        this.feedback=feedback;
        this.essayRef=validateEssayRef(essayRef);
        this.compOne=validateComp(compOne);
        this.compTwo=validateComp(compTwo);
        this.compThree=validateComp(compThree);
        this.compFour=validateComp(compFour);
        this.compFive=validateComp(compFive);
    }

    public Integer calculateAllScore(List<Integer> comps){
        Integer score=0;
        for(Integer comp:comps){
            score+=comp;
        }
        return score;
    }

    private EssayDomain validateEssayRef(EssayDomain essay){
        if (essay==null){throw new DomainException("a referencia essay não pode ser nula");}
        return essayRef;
    }

    private Integer validateComp(Integer comp){
        if (comp==null){throw new DomainException("a competencia não pode ser nula");}

        if (comp<=0||comp>5){throw new DomainException("a competencia não pode ser menor ou igual a 0,e maior que 5.");}

        return comp;
    }
}
