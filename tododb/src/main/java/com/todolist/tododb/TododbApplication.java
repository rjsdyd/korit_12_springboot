package com.todolist.tododb;

import com.todolist.tododb.domain.Todo;
import com.todolist.tododb.domain.TodoRepository;
import com.todolist.tododb.domain.User;
import com.todolist.tododb.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TododbApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TododbApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TododbApplication.class, args);
		logger.info("애플리케이션이 실행됩니다.");

	}
	private final UserRepository userRepository;
	private final TodoRepository todoRepository;

	public TododbApplication(UserRepository userRepository, TodoRepository todoRepository) {
		this.userRepository = userRepository;
		this.todoRepository = todoRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("김일", "1111", "user");
		User user2 = new User("김이", "2222", "user");
		userRepository.saveAll(Arrays.asList(user1, user2));
		Todo todo1 = new Todo("닝텐토", true, user1);
		Todo todo2 = new Todo("닝텐토 스위치", false, user2);
		todoRepository.saveAll(Arrays.asList(todo1,todo2));
	}
}
