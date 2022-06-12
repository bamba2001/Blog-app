package spring.blog.services;


public interface NotificationService {
	void addInfoMessage(String message);
	void addErrorMessage(String message);
}
