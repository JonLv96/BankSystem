package com.cn.bank.service;

import com.cn.bank.domain.User;

public interface BankService {

	void register(User user) throws Exception;

	User login(User user)throws Exception;

	void deposit(User user1)throws Exception;

	User findUserByCounter(User user)throws Exception;

	void modify(User user1)throws Exception;

	void tansfer(User user_current, User user_target, double money)throws Exception;

	
}
