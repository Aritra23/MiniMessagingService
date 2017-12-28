/**
 * 
 */
package controller;

/**
 * @author Aritra
 *
 */
import dao.MessagesDAO;
import model.People;
import model.Followers;
import model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

public class MessageController {
	
	// Instance of MessageDAO
		private MessagesDAO myMessageDAO;

		/**
		* Constructor Function to initialize the beans
		* @author Aritra
		* @param myMessageDAO DAO
		*/
		@Autowired
		public MessageController(MessagesDAO myMessageDAO) {
			this.myMessageDAO = myMessageDAO;
		}

		/**
		* Function to add a new user message
		* @author Aritra
		* @param content String containing the message content. This is also a
		* PathVariable. To add a message, append /message/content="message" to the
		* localhost URL, where "message" is the content of your message.
		* @return ResponseEntity JSON object
		*/
		@RequestMapping(value="/message/content={content}", method=RequestMethod.POST, produces="application/json")
		@ResponseBody
		public ResponseEntity writeNewMessage(@PathVariable String content) {
			int status = myMessageDAO.addMessage(content);
			if (status == 1)
				return ResponseEntity.ok("{\"message\":\"Success!\"}");
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Error!\"}");
		}

		/**
		* Function to view the messages of the current user and his/her followers
		* @author Aritra
		* @return List of messages
		*/
		@RequestMapping(value="/message", method=RequestMethod.GET, produces="application/json")
		@ResponseBody
		public List<Messages> userTweets() {
			return myMessageDAO.getUserMessages();
		}

		/**
		* Function to filter user messages based on a keyword
		* @author Aritra
		* @param keyword String containing the keyword for filtering by.
		* @return Filtered list of messages.
		*/
		@RequestMapping(value="/message/search={keyword}", method=RequestMethod.GET, produces="application/json")
		@ResponseBody
		public List<Messages> searchUserTweets(@PathVariable String keyword) {
			return myMessageDAO.searchUserMessages(keyword);
		}

}
