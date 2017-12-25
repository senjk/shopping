
package shopping.entity;

import java.util.Date;

/**
 * 
 * @author 程森
 *2017年10月22日下午10:49:03
 */

public class Account {
	
	    private String code;  //账户
	    private String name;    //姓名
	    private String password;  //密码
	    private String telphone;// 电话
	    private Date birthday;// 生日
		private String sex;// 性别
		private String email;//邮箱
		
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
	
		public String getTelphone() {
			return telphone;
		}
		public void setTelphone(String telphone) {
			this.telphone = telphone;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date brithday) {
			this.birthday =  brithday;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}
