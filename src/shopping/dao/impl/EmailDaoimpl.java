/**
 * @author 程森
 *2017年12月26日上午9:48:16
 */
package shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import shopping.common.DataSources;
import shopping.common.Emaildata;
import shopping.dao.IEmailDao;
import shopping.entity.Account;


/**
 * @author 程森
 *2017年12月26日上午9:48:16
 */
public class EmailDaoimpl implements IEmailDao {

	

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	String num=null;
	
	public int sendEmail(String messages,String email) {
			// TODO Auto-generated method stub
			Emaildata com=new Emaildata();
			// TODO Auto-generated method stub
			 // 收件人电子邮箱
		      String to = email;
		 
		      // 发件人电子邮箱
		      String from = "18355093308@163.com";
		 
		      // 指定发送邮件的主机为 localhost
		      String host = "localhost";
		      Properties props = System.getProperties();
		        props.put("mail.host", host);
		        props.put("mail.transport.protocol", "smtp");
		      // 获取系统属性
		      Properties properties = System.getProperties();
		 
		      // 设置邮件服务器
		      properties.setProperty("mail.smtp.host", host);
		 
		      // 获取默认session对象
		      Session session = Session.getDefaultInstance(properties);
		 
		      try{
		         // 创建默认的 MimeMessage 对象
		         MimeMessage message = new MimeMessage(session);
		 
		         // Set From: 头部头字段
		         message.setFrom(new InternetAddress(from));
		 
		         // Set To: 头部头字段
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(to));
		 
		         // Set Subject: 头部头字段
		         message.setSubject("合肥市威诗朗酒庄!");
		 
		         // 设置消息体
		         message.setText("您的验证码为:"+messages);
		       
		         // 发送消息
		         String server = "smtp.163.com";  
			      String username =com.getEmail() ;  
			      String password = com.getPassword();  
			                
			      Transport transport = session.getTransport();  
			      transport.connect(server, username, password);  
			      transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));  
			      transport.close();
		        
		      }catch (MessagingException mex) {
		         mex.printStackTrace();
		         return 0;
		      }
		       
			return 1;
		}

	@Override
	public String mail(String code) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="SELECT email FROM account where code='"+code+"';";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
			Account account=new Account();
			account.setEmail(rs.getString("email"));
			num=account.getEmail();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

}
