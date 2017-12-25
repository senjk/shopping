package shopping.service;



import java.util.List;


import shopping.entity.Account;
import shopping.entity.Drinks;
import shopping.entity.Page;
import shopping.entity.Userbuy;


public interface IDrinkService {
	/**
	 * 修改客户
	 * @param account
	 * @return
	 */
	public boolean update(Account account);
	/**
	 * 增加客户
	 * @param account
	 * @return
	 */
	public boolean add(Account account);
	/**
	 * 商品展示
	 * @param drink
	 * @return
	 */
	public List<Drinks> Drinkshow(int s);
	/**
	 * 订单
	 * @param userbuy
	 * @return
	 */
	public boolean orderbuy(Userbuy userbuy);
	/**
	 * 付款
	 * @param userbuy
	 * @return
	 */
	public boolean pay(Userbuy userbuy);
	/**
	 * 
	 * @param userbuy
	 * @return
	 */
	public int ordernum(Userbuy userbuy);
	/**
	 * 订单页
	 * @param userbuy
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	
	public Page userbuy(Userbuy userbuy,int pageNo, int pageSize);
	/**
	 * 购物车
	 * @param userbuy
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page buycar(Userbuy userbuy,int pageNo, int pageSize);
	/**
	 * 
	 * @param ordernum
	 * @param status
	 * @return
	 */
	public boolean updatest(int ordernum,int status);
}
