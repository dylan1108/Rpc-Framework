package com.spring.anno;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zhangwei_david
 * @version $Id: DateValidatorRule.java, v 0.1 2015年5月30日 上午11:17:09 zhangwei_david Exp $
 */
@CustomerRule
public class DateValidatorRule extends AbastractCustomerValidatorRule {
  /**
   * @see com.cathy.core.service.annotation.rule.CustomerValidatorRule#support(java.lang.annotation.Annotation, java.lang.Object)
   */
  @Override
  public boolean support(Annotation annotation) {
    return annotation instanceof DateString;
  }
  /**
   * @see com.cathy.core.service.annotation.rule.AbastractCustomerValidatorRule#validProperty(java.lang.annotation.Annotation, java.lang.Object)
   */
  @Override
  public void validProperty(Annotation annotation, Object property, PostHandler postHandler) {
    DateString ds = (DateString) annotation;
    if (parse(ds.pattern(), (String) property) == null) {
      postHandler.postHanle(ds.errorCode(), ds.message());
    }
  }
  private Date parse(String pattern, String property) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
      return sdf.parse(property);
    } catch (ParseException e) {
      //do noting
    }
    return null;
  }
}