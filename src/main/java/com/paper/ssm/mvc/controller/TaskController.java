package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.task.Task;
import com.paper.ssm.mvc.service.TaskService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: TaskController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:53
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/tasks")
public class TaskController extends AbstractController<Task> {

    @Resource
    TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Task> selectListByQuery(Task query) {
        return this.taskService.selectListByQuery(query);
    }

    @Override
    public Task insert(Task record) {
        return null;
    }

    @Override
    public int delete(Task record) {
        return 0;
    }

    @Override
    public Task update(Task record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Task selectByPrimaryKey(@PathVariable Integer id) {
        return this.taskService.selectByPrimaryKey(id);
    }
}
