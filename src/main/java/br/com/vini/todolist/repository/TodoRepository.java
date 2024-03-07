package br.com.vini.todolist.repository;

import br.com.vini.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
