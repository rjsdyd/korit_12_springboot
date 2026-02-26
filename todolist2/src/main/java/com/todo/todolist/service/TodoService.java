package com.todo.todolist.service;

import com.todo.todolist.dto.TodoRequest;
import com.todo.todolist.dto.TodoResponse;
import com.todo.todolist.entity.Todo;
import com.todo.todolist.entity.User;
import com.todo.todolist.repository.TodoRepository;
import com.todo.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // POST 요청을 하는 비지니스 로직 작성
    @Transactional
    public TodoResponse createdTodo(Long userId, TodoRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없음."));

        // DTO -> Entity로의 변환
        Todo todo = new Todo(request.content(), user);      // Todo 객체 만들어지면 isCompleted = false가 적용됨.
        Todo savedTodo= todoRepository.save(todo);

        // Entity -> DTO로 변환해서 Controller로 넘겨줄 것임.
        return new TodoResponse(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
    }

    // Get 요청을 하는 비지니스 로직 작성
    @Transactional(readOnly = true)
    public List<TodoResponse> getTodoList() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponse(todo.getId(), todo.getContent(), todo.isCompleted()))
                .collect(Collectors.toList());
    }

}
