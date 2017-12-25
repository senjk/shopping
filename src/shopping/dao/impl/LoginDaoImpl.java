package shopping.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shopping.common.DataSources;
import shopping.dao.ILoginDao;
import shopping.entity.Account;


public class LoginDaoImpl implements ILoginDao {
   private Connection conn;
   private PreparedStatement pst;
   private Statement st;
   private ResultSet rs;
	@Override
	public int login(String name, String pwd) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			conn = DataSources.getconn();
			String sql = "select * from account where code ='" + name + "' and password ='" + pwd+"'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.last();
			i = rs.getRow();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSources.close(rs, st, conn);
		}
		return i;
	}
	@Override
	public List<Account> selectname(String code, String password) {
		// TODO Auto-generated method stub
		 Account account=new Account();
		 conn = DataSources.getconn();
		 List<Account> listAccount=new ArrayList<Account>();
			String sql = "select * from account where code ='" + code + "' and password ='" + password+"'";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					account.setName(rs.getString("name"));
					account.setCode(rs.getString("code"));
					account.setPassword(rs.getString("password"));
					account.setEmail(rs.getString("email"));
					account.setSex(rs.getString("sex"));
					account.setBirthday(rs.getDate("brithday"));
					account.setTelphone(rs.getString("telphone"));
				}
				listAccount.add(account);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DataSources.close(rs, pst, conn);    //调用关闭方法
			} 
			
		return listAccount;
	}
	@Override
	public int forget(String name) {
		// TODO Auto-generated method stub
		int i = 0;
		conn = DataSources.getconn();
		String sql = "select * from account where code ='" + name + "'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.last();
			i = rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.close(rs, st, conn);
		}
		return i;
	}
	@Override
	public int repwd(String code,String pwd) {
		// TODO Auto-generated method stub
		int i = 0;
		conn = DataSources.getconn();
		String sql="update account set password='"+pwd+"' where code='"+code+"';";
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
