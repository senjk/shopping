package shopping.dao;



import java.util.List;


import shopping.entity.Account;
import shopping.entity.Drinks;
import shopping.entity.Page;
import shopping.entity.Userbuy;


public interface IDrinkDao {
	public int update(Account account);
	public int add(Account account);
	public List<Drinks> drinkshow(int s);
	public int orderbuy(Userbuy userbuy);
	public int ordernum(Userbuy userbuy);
	public int pay(Userbuy userbuy);
	public int updatest(int ordernum ,int status);
	public Page userbuy(Userbuy userbuy,int pageNo, int pageSize);
	public Page buycar(Userbuy userbuy,int pageNo, int pageSize);
}
