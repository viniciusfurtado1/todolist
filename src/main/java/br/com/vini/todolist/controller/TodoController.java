package br.com.vini.todolist.controller;

import br.com.vini.todolist.dto.TodoPostPutDto;
import br.com.vini.todolist.entity.Todo;
import br.com.vini.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<List<Todo>> create(@RequestBody @Valid TodoPostPutDto todoPostPutDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoPostPutDto));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.list());
    }

    @PutMapping("{id}")
    public ResponseEntity<List<Todo>> update(@PathVariable Long id, @RequestBody @Valid TodoPostPutDto todoPostPutDto) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.update(id, todoPostPutDto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<List<Todo>> updateRealizado(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateRealizado(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Todo>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(todoService.delete(id));
    }
}
