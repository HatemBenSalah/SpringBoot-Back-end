package com.template.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.template.entity.NotificationTokenEntity;
import com.template.entity.UserEntity;
import com.template.repositories.NotificationTokensRepository;
import com.template.service.NotificationTokenService;

@RestController
@RequestMapping("/notificationsController")
public class NotificationsTokenController {

	@Autowired
	private NotificationTokensRepository notiRep;
	
	@Autowired
	NotificationTokenService notiService;
	
	//Get Token list
	@GetMapping(path="/getAllNotificationsToken")
	public List<NotificationTokenEntity> getAllNotification(){
		return notiRep.findAll();
	}
	
	//Get the tokens for a specific user
	@GetMapping(path="/getNotificationsTokensForUser")
	public List<NotificationTokenEntity> getNotificationsTokensForUser(@Valid @RequestBody UserEntity userExample){
		return notiRep.findByUserId(userExample);
	}
	
	//Add a new token for a new connection in a new browser ( or a borowser with a reset cache)
	@PostMapping(path="/addNotificationToken")
	public NotificationTokenEntity addNotificationToken(@Valid @RequestBody NotificationTokenEntity notification) {
		return notiRep.save(notification);
	}
	
	//Send notifications to all the users in the list
	@PostMapping(path="/send", produces="application/json")
	public ResponseEntity<String> sendNotif(String Title, String content) throws JSONException {
		List<NotificationTokenEntity> listNotif = new ArrayList<NotificationTokenEntity>();
		listNotif = getAllNotification();
			if (listNotif.size() > 0) {
				try {
				for(int i = 0; i<listNotif.size(); i++) {
					notiService.sendPushNotification(listNotif.get(i).getToken(), Title, content);
				}
				return new ResponseEntity<>("success", HttpStatus.OK);
				} catch (IOException e) {
				}
				return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
				}
			return new ResponseEntity<>("Aucun token na été trouvé!", HttpStatus.BAD_REQUEST);
		
	//to send a notification use this code in the right place of your controller or service
	/*
	 //add declaration
	 * @Autowired
	NotificationTokenController tokenController;
	//add inside the method
	  tokenController.sendNotif("title","Content");
	 */
	}
}
