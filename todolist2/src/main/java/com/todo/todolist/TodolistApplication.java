package com.todo.todolist;

import com.todo.todolist.entity.Todo;
import com.todo.todolist.repository.TodoRepository;
import com.todo.todolist.entity.User;
import com.todo.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class TodolistApplication implements CommandLineRunner {
	private UserRepository userRepository;
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("김일", "1234", "USER");
		User user2 = new User("이이", "7890", "ADMIN");
		userRepository.saveAll(Arrays.asList(user1, user2));

		Todo todo1 = new Todo("SQLD", user1);
		Todo todo2 = new Todo("자습", user2);
		todoRepository.saveAll(Arrays.asList(todo1, todo2));
	}
}
