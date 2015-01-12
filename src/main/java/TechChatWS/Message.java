package TechChatWS;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {

	@Id 
	private String id;

	private String message;
	private String type;
    private String datetime;
	private String user;

	private long topic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	

	public String getDatetime() {
		return datetime;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Long getTopic() {
		return topic;
	}

	public void setTopic(Long topic) {
		this.topic = topic;
	}

	
	 @Override
	     public String toString() {
	         return "Message {" +
	                 "id='" + id +
	                 ", message='" + message +
	                 ", topic='" + topic +
	                 ", user=" + user +
	                 ", type=" + type +
	                 ", datetime=" + datetime +
	                 '}';
	     }

}