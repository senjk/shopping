package shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import shopping.dao.ILoginDao;
import shopping.dao.impl.LoginDaoImpl;
import shopping.entity.Account;
import shopping.service.ILoginservice;

public class LoginServiceImpl implements ILoginservice {
	ILoginDao iLogin=new LoginDaoImpl();
	@Override
	public boolean login(String name, String pwd) {
		// TODO Auto-generated method stub
		
		int i= iLogin.login(name, pwd);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Account> selectname(String code, String password) {
		// TODO Auto-generated method stub
		List<Account> listAccount=new ArrayList<Account>();
		listAccount=iLogin.selectname(code, password);
		return listAccount;
	}

	@Override
	public boolean forget(String name) {
		// TODO Auto-generated method stub
		int i= iLogin.forget(name);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean repwd(String code, String pwd) {
		// TODO Auto-generated method stub
		int i= iLogin.repwd(code, pwd);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

}
