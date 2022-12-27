package com.codestates.preproject.vote.annotation;

import com.codestates.preproject.vote.dto.request.VotePostReqDto;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OpinionValidator.class)
public @interface VoteOpinion {
    String message() default "1 혹은 -1";
    Class[] groups() default {};
    Class[] payload() default {};


}
