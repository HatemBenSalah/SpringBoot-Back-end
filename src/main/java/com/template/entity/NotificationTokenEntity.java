package com.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION")
public class NotificationTokenEntity {
	
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="Token")
		private String token;
		
		@JoinColumn(name="USER_ID")
		@ManyToOne
		private UserEntity userId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public UserEntity getUserId() {
			return userId;
		}

		public void setUserId(UserEntity userId) {
			this.userId = userId;
		}
		
}
