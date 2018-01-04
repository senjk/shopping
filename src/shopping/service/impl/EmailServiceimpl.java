/**
 * @author 程森
 *2017年12月26日上午10:02:47
 */
package shopping.service.impl;

import shopping.dao.IEmailDao;
import shopping.dao.impl.EmailDaoimpl;
import shopping.service.IEmailService;

/**
 * @author 程森
 *2017年12月26日上午10:02:47
 */
public class EmailServiceimpl implements IEmailService {
   IEmailDao iEmail=new EmailDaoimpl();
	/* (non-Javadoc)
	 * @see shopping.service.IEmailService#sendEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean sendEmail(String message, String email) {
		// TODO Auto-generated method stub
		int i=iEmail.sendEmail(message, email);
		if(1==i){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see shopping.service.IEmailService#mail(java.lang.String)
	 */
	@Override
	public String mail(String code) {
		// TODO Auto-generated method stub
		String email=iEmail.mail(code);
		
		
		return email;
	}

}
