package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*类名和方法不能修改
 */
public class Schedule {

    Map<Integer, Integer> nodeIdMap = new HashMap<Integer, Integer>();
    Map<Integer, TaskInfo> taskInfoMap = new HashMap<Integer, TaskInfo>();
    TaskInfo taskInfo = new TaskInfo();

    public int init() {
        nodeIdMap.clear();
        taskInfoMap.clear();
        System.out.println("E001初始化成功");
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if (nodeId > 0){
            if (nodeIdMap.containsKey(nodeId)){
                System.out.println("E005:服务节点已注册");
                return ReturnCodeKeys.E005;
            }
            nodeIdMap.put(nodeId, nodeId);
            System.out.println("E003:服务节点注册成功");
            return ReturnCodeKeys.E003;
        }else {
            System.out.println("E004:服务节点编号非法");
            return ReturnCodeKeys.E004;
        }
    }

    public int unregisterNode(int nodeId) {
        if (nodeId > 0) {
            if (nodeIdMap.containsKey(nodeId)) {
                nodeIdMap.remove(nodeId);
                System.out.println("E006:服务节点注销成功");
                return ReturnCodeKeys.E006;
            }else {
                System.out.println("E007:服务节点不存在");
                return ReturnCodeKeys.E007;
            }
        }else{
            System.out.println("E004:服务节点编号非法");
            return ReturnCodeKeys.E004;
        }
    }


    public int addTask(int taskId, int consumption) {
        if (taskId > 0){
            if (taskInfoMap.containsKey(taskId)){
                System.out.println("E010:任务已添加");
                return ReturnCodeKeys.E010;
            }
            taskInfo.setTaskId(taskId);
            taskInfo.setNodeId(consumption);
            taskInfoMap.put(taskId, taskInfo);
            System.out.println("E008任务添加成功");
            return ReturnCodeKeys.E008;
        }else{
            System.out.println("E009:任务编号非法");
            return ReturnCodeKeys.E009;
        }
    }


    public int deleteTask(int taskId) {
        if (taskId > 0){
            if (taskInfoMap.containsKey(taskId)){
                taskInfoMap.remove(taskId);
                System.out.println("E011:任务删除成功");
                return ReturnCodeKeys.E011;
            }
            System.out.println("E012:任务不存在");
            return ReturnCodeKeys.E012;
        }else{
            System.out.println("E009:任务编号非法");
            return ReturnCodeKeys.E009;
        }
    }


    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

}
