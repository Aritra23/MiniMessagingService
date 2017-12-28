/**
 * 
 */
package dao;
import java.util.List;
import model.Messages;

/**
 * @author Aritra
 *
 */
public interface MessagesDAO {
	public int addMessage(String content);
	public List<Messages> getUserMessages();
	public List<Messages> searchUserMessages(String keyword);
	public int getId();

}
