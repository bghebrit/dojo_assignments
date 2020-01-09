package com.codingdojo.task.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.task.models.Task;
import com.codingdojo.task.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepo;
	
	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}
	//list all tasks
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	//create task
	public Task createTask(Task t) {
		return taskRepo.save(t);
	}
	//find task by id
	public Task getTask(Long id) {
		Optional <Task> task = taskRepo.findById(id);
		if (task.isPresent()) {
			return task.get();
		}else {
			return null;
		}
	}
	//delete task
	public void deleteTask(Long taskId) {
		taskRepo.deleteById(taskId);
	}
	//update task
	public void updateTask(Task task) {
		taskRepo.save(task);
	}
	
	
}
