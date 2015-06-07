package tk.bhargavk.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tk.bhargavk.messenger.database.DatabaseClass;
import tk.bhargavk.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1l, new Message(1, "Hello World", "bhargav"));
		messages.put(2l, new Message(2, "Hello Jersey", "bhargav"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values()); 		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;		
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
