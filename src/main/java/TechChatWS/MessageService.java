package TechChatWS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	    @Autowired
	    private MessageRepository repository;

/*
 	List<Message> findAll();
	List<Message> findById(@Param("id") Long id);
	List<Message> findByTopic(@Param("topic") Long topic);
	List<Message> findByType(@Param("topic") Long topic, @Param("type") String type);	    
 */
	    public List <Message> getAll(){
	        return repository.findAll();
	    }
	    
	    public List <Message> getById(String id){
	        return repository.findById(id);
	    }
	
	    public List <Message> getByTopic(Long topic){
	        return repository.findByTopic(topic);
	    }
	    
	    public List <Message> getByType(Long topic, String type){
	        return repository.findByType(topic, type);
	    }
	    
	    public void deleteById(Long id) {
	    	repository.delete(id.toString());
	    }

	    public void save(Message msg) {
	    	repository.save(msg);
	    }	  
	    
	    public void update(Message msg) {
	    	repository.save(msg);
	    }		    
}
