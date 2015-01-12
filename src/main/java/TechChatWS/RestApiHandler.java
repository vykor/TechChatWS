package TechChatWS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiHandler extends AbstractRestHandler {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MessageRepository MessageRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(value="/api/messages/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Message> findById(@PathVariable("id") String id) {
		log.info("Returning message id: " + id);
		return MessageRepository.findById(id);
	}
	
	@RequestMapping(value="/api/messages/{id}", method=RequestMethod.PUT)
	public @ResponseBody String updateById(@RequestBody Message message) {
		//log.info("Returning message id: " + id);
		//return MessageRepository.findById(id);
		mongoTemplate.save(message);
		log.info("Updated message");
		return "Message updated.";
	}
	
	@RequestMapping(value="/api/messages/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String delteById(@RequestBody Message message) {
		//log.info("Returning message id: " + id);
		//return MessageRepository.findById(id);
		mongoTemplate.remove(message);
		log.info("Deleted message");
		return "Message deleted.";
	}
	
	@RequestMapping(value="/api/messages", method=RequestMethod.GET)
	public @ResponseBody List<Message> findAll(
			@RequestParam(value="page", required=false) Integer page,
			@RequestParam(value="size", required=false) Integer size) {
		
		if (page == null)
			page = 0;
		
		if (size == null)
			size = 265;

		Page<Message> pageOfMessage = MessageRepository.findAll(new PageRequest(page, size));
		
		log.info("Returning all messages");
		
		return pageOfMessage.getContent();
	}

	@RequestMapping(value="/api/messages", method=RequestMethod.POST)
	public @ResponseBody String addPerson(@RequestBody Message message) {
		mongoTemplate.save(message);
		log.info("Saved message");
		return "Message added.";
	}
	
}