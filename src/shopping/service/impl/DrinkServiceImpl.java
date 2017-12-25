package shopping.service.impl;


import java.util.ArrayList;
import java.util.List;

import shopping.dao.IDrinkDao;
import shopping.dao.impl.DrinkDaoImpl;
import shopping.entity.Account;
import shopping.entity.Drinks;
import shopping.entity.Page;
import shopping.entity.Userbuy;
import shopping.service.IDrinkService;


public class DrinkServiceImpl implements IDrinkService {
  IDrinkDao iDrink=new DrinkDaoImpl();
	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		int num=iDrink.update(account);
		
		boolean flag=false;
		if(num==1){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean add(Account account) {
		// TODO Auto-generated method stub
		int num=iDrink.add(account);
		boolean flag=false;
		if(num==1){
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Drinks> Drinkshow(int s) {
		// TODO Auto-generated method stub
		List<Drinks> Drinkshow=new ArrayList<Drinks>();
			Drinkshow=iDrink.drinkshow(s);
		return Drinkshow;
	}

	@Override
	public boolean orderbuy(Userbuy userbuy) {
		// TODO Auto-generated method stub
		int num=iDrink.orderbuy(userbuy);
		boolean flag=false;
		if(num==1){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean pay(Userbuy userbuy) {
		// TODO Auto-generated method stub
		int num=iDrink.pay(userbuy);
		boolean flag=false;
		if(num==1){
			flag=true;
		}
		return flag;
	}

	@Override
	public int ordernum(Userbuy userbuy) {
		// TODO Auto-generated method stub
		int num=iDrink.ordernum(userbuy);
		return num;
	}

	@Override
	public Page userbuy(Userbuy userbuy, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Page page=iDrink.userbuy(userbuy,pageNo,pageSize);
		return page;
	}

	@Override
	public Page buycar(Userbuy userbuy, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Page page=iDrink.buycar(userbuy,pageNo,pageSize);
		return page;
	}

	@Override
	public boolean updatest(int ordernum, int status) {
		// TODO Auto-generated method stub
		int num=iDrink.updatest(ordernum, status);
		boolean flag=false;
		if(num==1){
			flag=true;
		}
		return flag;
		
	}

	
	
	
}
