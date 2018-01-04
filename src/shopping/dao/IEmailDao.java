package shopping.dao;

public interface IEmailDao {
	public int sendEmail(String message,String email);
	public String mail(String code);
}
