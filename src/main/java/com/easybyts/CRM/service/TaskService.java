package com.easybyts.CRM.service;

import com.easybyts.CRM.model.Task;
import com.easybyts.CRM.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TaskService {

//    @Autowired
//    private EmailService emailService;

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task){
        Task savedTask = taskRepository.save(task);

//        if (task.getDueDate() != null) {
//            emailService.sendEmail(
//                    task.getAssignedToEmail(),
//                    "Task Deadline Reminder: " + task.getTitle(),
//                    "The task \"" + task.getTitle() + "\" is due on " + task.getDueDate()
//            );
//        }

        return savedTask;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }


    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
