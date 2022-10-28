package com.soprasteria.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@Column(name="id")
		private int id;
		private String description;
		private boolean isDone = false;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isDone() {
			return isDone;
		}
		public void setDone(boolean isDone) {
			this.isDone = isDone;
		}
		
		
		
}
