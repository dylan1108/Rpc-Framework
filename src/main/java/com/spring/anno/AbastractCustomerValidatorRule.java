package com.spring.anno;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

/**
 *
 * @author zhangwei_david
 * @version $Id: AbastractCustomerValidatorRule.java, v 0.1 2015年5月30日 上午11:22:19 zhangwei_david Exp $
 */
public abstract class AbastractCustomerValidatorRule implements CustomerValidatorRule {
  /**
   * @see com.cathy.core.service.annotation.rule.CustomerValidatorRule#support(java.lang.annotation.Annotation)
   */
  public abstract boolean support(Annotation annotation);
  /**
   * @param <T>
   * @see com.cathy.core.service.annotation.rule.CustomerValidatorRule#valid(java.lang.annotation.Annotation, java.lang.reflect.Field, org.springframework.validation.Errors)
   */
  public void valid(Annotation annotation, Object target, final Field field, final Errors errors)
                                                   throws Exception {
    preHandle(annotation, target, field, errors);
    PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(target.getClass(),
      field.getName());
    Method reader = propertyDescriptor.getReadMethod();
    Object property = reader.invoke(target);
    validProperty(annotation, property, new PostHandler() {
      public void postHanle(String errorCode, String message) {
        errors.rejectValue(field.getName(), errorCode, message);
      }
    });
  }
  public static interface PostHandler {
    public void postHanle(String errorCode, String message);
  }
  /**
   *
   */
  private void preHandle(Annotation annotation, Object target, Field field, Errors errors) {
    Assert.notNull(target);
    Assert.notNull(annotation);
    Assert.notNull(errors);
    Assert.notNull(field);
  }
  public abstract void validProperty(Annotation annotation, Object property,
                     PostHandler postHandler);
}