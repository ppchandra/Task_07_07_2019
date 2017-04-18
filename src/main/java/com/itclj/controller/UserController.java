package com.itclj.controller;

import com.alibaba.fastjson.JSON;
import com.itclj.bean.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lujun.chen on 2017/4/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping("/add")
  public UserBean add(UserBean userBean) {
    logger.info("request param:{}", JSON.toJSON(userBean));
    return userBean;
  }

}
