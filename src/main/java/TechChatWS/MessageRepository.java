package TechChatWS;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository extends MongoRepository<Message, String> {

	List<Message> findAll();
	List<Message> findById(@Param("id") String id);
	List<Message> findByTopic(@Param("topic") Long topic);
	List<Message> findByType(@Param("topic") Long topic, @Param("type") String type);
	
	//Long deleteById(@Param("id") Long id);
	
}