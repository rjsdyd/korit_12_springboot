package com.todo.todolist.controller;

import com.todo.todolist.dto.TodoRequest;
import com.todo.todolist.dto.TodoResponse;
import com.todo.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // todo 등록 API
    @PostMapping("/{userId}")
    public ResponseEntity<TodoResponse> addTodo(@PathVariable Long userId, @RequestBody TodoRequest request) {
        TodoResponse response = todoService.createdTodo(userId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // todo 조회 API
    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        return ResponseEntity.ok(todoService.getTodoList());
    }
}
