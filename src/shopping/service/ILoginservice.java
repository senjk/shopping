package shopping.service;

import java.util.List;

import shopping.entity.Account;



public interface ILoginservice {
	public boolean login(String name, String pwd);
	public boolean repwd(String code, String pwd);
	public boolean forget(String name);
	public List<Account> selectname(String code, String password);
}
