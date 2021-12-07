package com.muedsa.intellij.textReader.action;

import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.muedsa.intellij.textReader.composes.ReaderWindow;
import com.muedsa.intellij.textReader.composes.ReaderWindowHolder;
import com.muedsa.intellij.textReader.notify.Notification;

public class NextLineAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        ReaderWindow readerWindow = ReaderWindowHolder.get(e.getProject());
        if(readerWindow == null){
            Notification.sendHiddenNotify(e.getProject(), "未初始化ToolWindow, 请点击工具栏打开一次窗口", NotificationType.WARNING);
        }else{
            if(readerWindow.isReadyLineAction()){
                Notification.sendHiddenNotify(e.getProject(), readerWindow.nextLine(), NotificationType.INFORMATION);
            }else{
                Notification.sendHiddenNotify(e.getProject(), "请选择文件载入或清除筛选项", NotificationType.WARNING);
            }
        }
    }
}
