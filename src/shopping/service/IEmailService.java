package shopping.service;

public interface IEmailService {
	public boolean sendEmail(String message,String email);
	public String mail(String code);
}
