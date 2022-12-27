package com.codestates.preproject.vote.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OpinionValidator implements ConstraintValidator<VoteOpinion, Integer>{

    @Override
    public boolean isValid(Integer opinion, ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();

        if(opinion == 1|| opinion== -1){
            return true;
        }
        return false;
        }
    }
