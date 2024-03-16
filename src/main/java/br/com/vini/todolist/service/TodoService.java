package br.com.vini.todolist.service;

import br.com.vini.todolist.dto.TodoPostPutDto;
import br.com.vini.todolist.entity.Todo;
import br.com.vini.todolist.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(TodoPostPutDto todoPostPutDto) {
        var todo = new Todo();
        BeanUtils.copyProperties(todoPostPutDto, todo);
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long id, TodoPostPutDto todoPostPutDto) {
        var todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Não Existe."));
        BeanUtils.copyProperties(todoPostPutDto, todo);
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

    public List<Todo> updateRealizado(Long id) {
        var todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Não Existe."));
        todo.setRealizado(!todo.isRealizado());
        todoRepository.save(todo);
        return list();
    }
}
