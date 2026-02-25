package com.todolist.tododb.domain;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(name = "Todo API", description = "Todolist")
@RepositoryRestResource(path = "todos")
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
