package com.codestates.preproject.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;

@Component
public class CustomBeanUtils<T> {
    public T copyNonNullProperties(T source, T destination) {
        if (source == null || destination == null || source.getClass() != destination.getClass()) {
            return null;
        }

        final BeanWrapper src = new BeanWrapperImpl(source); // 클래스의 필드 정보를 가지고 올 수 있음
        final BeanWrapper dest = new BeanWrapperImpl(destination);

        for (final Field property : source.getClass().getDeclaredFields()) { // for문을 돌며 source 객체의 필드를 가져옴 cf. Reflection API에서 자주 쓰는 방식
            Object sourceProperty = src.getPropertyValue(property.getName()); // 필드 안에 들어있는 값을 가져옴
            if (sourceProperty != null && !(sourceProperty instanceof Collection<?>)) { // null이 아닌 필드 = 업데이트/수정하고자 하는 정보
                dest.setPropertyValue(property.getName(), sourceProperty); // 내가 수정하고자 하는 정보들만 dest 객체(=destination 객체 안에 포함되는 것) 안에 업데이트됨
            }
        }

        return destination;
    }
}
