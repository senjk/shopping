package shopping.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import shopping.common.DataSources;

import shopping.dao.IDrinkDao;
import shopping.entity.Account;
import shopping.entity.Drinks;
import shopping.entity.Page;
import shopping.entity.Userbuy;







public class DrinkDaoImpl implements IDrinkDao {
	private Statement st;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	int num=0;
	int nums=0;
	int totalCount=0;
	Page page=null;
	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		st=DataSources.gets();
		String sql="update account set password='"+account.getPassword()+"',email='"+account.getEmail()+"',brithday='"+new Date(account.getBirthday().getTime())+"',telphone='"+account.getTelphone()+"',sex='"+account.getSex()+"'where code='"+account.getCode()+"'and name='"+account.getName()+"';";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, pst, conn);    //调用关闭方法
		} 
		return 1;
	}

	@Override
	public int add(Account account) {
		// TODO Auto-generated method stub
		st=DataSources.gets();
		StringBuffer sql=new StringBuffer("insert into account(code,name,password,email,telphone,brithday,sex) value ('");
		sql.append(account.getCode()+"','");
		sql.append(account.getName()+"','");
		sql.append(account.getPassword()+"','");
		sql.append(account.getEmail()+"','");
		sql.append(account.getTelphone()+"','");
		sql.append(new Date(account.getBirthday().getTime())+"','");
		sql.append(account.getSex()+"')");
		try {
			String mysql=sql.toString();
			
			st.executeUpdate(mysql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, pst, conn);    //调用关闭方法
		} 
		return 1;
	}


	@Override
	public List<Drinks> drinkshow(int s) {
		// TODO Auto-generated method stub
		Drinks drink=new Drinks();
		 conn = DataSources.getconn();
		 List<Drinks> listdrink=new ArrayList<Drinks>();
		 String sql = "select * from drinkk where class= "+s+" ;";
		 try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				drink=new Drinks();
				drink.setDrink(rs.getString("drink"));
				drink.setPrice(rs.getFloat("price"));
				drink.setChundu(rs.getString("chundu"));
				drink.setUrl(rs.getString("url"));
				drink.setOwnerid(rs.getInt("ownerid"));
				listdrink.add(drink);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.closeall(rs, pst, conn);
		}
			
		return listdrink;
	}

	@Override
	public int orderbuy(Userbuy userbuy) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="insert into userbuy(code,drink,number,url,price,address,status) values(?,?,?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, userbuy.getCode());
			pst.setString(2, userbuy.getDrink());
			pst.setInt(3, userbuy.getNumber());
			pst.setString(4, userbuy.getUrl());
			pst.setDouble(5, userbuy.getPrice());
			pst.setString(6, userbuy.getAddress());
			pst.setInt(7, userbuy.getStatus());
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int pay(Userbuy userbuy) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="update userbuy set status='"+userbuy.getStatus()+"'where code='"+userbuy.getCode()+"' and ordernum='"+userbuy.getOrdernum()+"';";
		try {
			pst=conn.prepareStatement(sql);
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int ordernum(Userbuy userbuy) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="SELECT ordernum FROM userbuy where code='"+userbuy.getCode()+"' and drink='"+userbuy.getDrink()+"' ORDER BY ordernum DESC LIMIT 1;";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
			Userbuy userbuyd=new Userbuy();
			userbuyd.setOrdernum(rs.getInt("ordernum"));
			nums=userbuyd.getOrdernum();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nums;
	}

	@Override
	public Page userbuy(Userbuy userbuy, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Userbuy> listUserBuy=new ArrayList<Userbuy>();
		st=DataSources.gets();
		try {
			String sql1="select count(code) from userbuy where status > 0 and status < 4 and code='"+userbuy.getCode()+"';";
			rs=st.executeQuery(sql1);
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
			String sql="select * from userbuy where status > 0 and status < 4 and code='"+userbuy.getCode()+"' order by ordernum desc limit "+(pageNo-1)*pageSize+","+pageSize+";";
			rs=st.executeQuery(sql);
			while(rs.next()){
				userbuy=new Userbuy();
				userbuy.setOrdernum(rs.getInt("ordernum"));
				userbuy.setUrl(rs.getString("url"));
				userbuy.setDrink(rs.getString("drink"));
				userbuy.setNumber(rs.getInt("number"));
				userbuy.setPrice(rs.getFloat("price"));
				userbuy.setStatus(rs.getInt("status"));
				userbuy.setAddress(rs.getString("address"));
				listUserBuy.add(userbuy);
			}
			page=new Page(pageSize, totalCount);
			page.setData(listUserBuy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, pst, conn);    //调用关闭方法
		} 
		return page;
	}

	@Override
	public Page buycar(Userbuy userbuy, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Userbuy> listUserBuy=new ArrayList<Userbuy>();
		st=DataSources.gets();
		try {
			String sql1="select count(code) from userbuy where status = 0 and code='"+userbuy.getCode()+"';";
			rs=st.executeQuery(sql1);
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
			String sql="select * from userbuy where status = 0 and code='"+userbuy.getCode()+"' order by ordernum desc limit "+(pageNo-1)*pageSize+","+pageSize+";";
			rs=st.executeQuery(sql);
			while(rs.next()){
				userbuy=new Userbuy();
				userbuy.setOrdernum(rs.getInt("ordernum"));
				userbuy.setUrl(rs.getString("url"));
				userbuy.setDrink(rs.getString("drink"));
				userbuy.setNumber(rs.getInt("number"));
				userbuy.setPrice(rs.getFloat("price"));
				userbuy.setStatus(rs.getInt("status"));
				userbuy.setAddress(rs.getString("address"));
				listUserBuy.add(userbuy);
			}
			page=new Page(pageSize, totalCount);
			page.setData(listUserBuy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, pst, conn);    //调用关闭方法
		} 
		return page;
	}

	@Override
	public int updatest(int ordernum, int status) {
		// TODO Auto-generated method stub
		int i = 0;
		conn = DataSources.getconn();
		String sql="update userbuy set status="+status+" where ordernum="+ordernum+";";
		try {
			pst=conn.prepareStatement(sql);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, st, conn);
		}
		return i;
	}



}
	
