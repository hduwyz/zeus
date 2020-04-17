package com.zeus.core.utils;

import com.zeus.core.exception.ParamValidatorException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReqParamValidatorUtil {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * 返回所有校验结果
     * @param t
     * @param groups
     * @param <T>
     * @return
     */
    public static <T>List<String> validateParam(T t, Class<?>... groups){
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);

        List<String> messageList = new ArrayList<String>();
        for (ConstraintViolation<T> constraintViolation: constraintViolations){
            messageList.add(constraintViolation.getMessage());
        }
        return messageList;
    }

    public static String validate(Object obj, Class<?>... groups){
        try {
            StringBuilder errorStr = new StringBuilder();
            List<String> errorList = validateParam(obj, groups);
            if (CollectionUtils.isEmpty(errorList)){
                return null;
            }
            errorList.forEach(row -> {
                errorStr.append(row + ",");
            });
            int length = errorStr.length();
            errorStr.delete(length-1, length);
            return errorStr.toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public static String validateWithDefault(Object obj, Class<?>... groups){
        int len = groups.length;
        Class<?>[] group = new Class[len+1];
        if (0 != len){
            for (int i=0; i<len; i++){
                group[i] = groups[i];
            }
        }
        group[len] = Default.class;
        return validate(obj, group);
    }

    public static void validator(Object obj, Class<?>... groups){
        String errorParam = validateWithDefault(obj, groups);
        if (!StringUtils.isEmpty(errorParam)){
            throw new ParamValidatorException("参数校验失败：" + errorParam);
        }

    }
}
