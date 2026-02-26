package com.todo.todolist.dto;

public record TodoResponse(Long id, String content, boolean isCompleted) {
}
