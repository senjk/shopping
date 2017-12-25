package shopping.dao;

import java.util.List;

import shopping.entity.Account;



public interface ILoginDao {
  public int login(String name,String pwd);
  public int forget(String name);
  public int repwd(String name,String pwd);
  public List<Account> selectname(String code, String password);
}
