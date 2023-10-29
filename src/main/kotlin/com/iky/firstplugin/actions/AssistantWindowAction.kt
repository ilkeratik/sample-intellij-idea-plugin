package com.iky.firstplugin.actions;

import com.iky.firstplugin.toolwindows.TimeToolWindowFactory
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.wm.ToolWindowManager

class AssistantWindowAction: AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.let { ToolWindowManager.getInstance(it).getToolWindow("AssistantTW")}?.show()
    }
}
