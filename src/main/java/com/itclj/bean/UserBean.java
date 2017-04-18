package com.itclj.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lujun.chen on 2017/4/17.
 */
public class UserBean implements Serializable {

  private static final long serialVersionUID = -4797002544487006107L;

  private Long id;

  private String name;

  private Integer age;

  private Date birthday;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}
