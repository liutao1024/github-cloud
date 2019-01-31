package cn.spring.mvn.core.entity.service.impl;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.entity.BankCard;
import cn.spring.mvn.core.entity.service.BankCardService;

@Repository("BankCardService")
public class BankCardServiceImpl extends IBatisServiceImpl<BankCard> implements BankCardService{

}
