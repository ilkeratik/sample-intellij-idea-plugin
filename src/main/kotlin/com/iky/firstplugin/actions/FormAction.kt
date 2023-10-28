package com.iky.firstplugin.actions;

import com.iky.firstplugin.views.DialogExample;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

class FormAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = DialogExample(e.project, true);
        dialog.show()

    }
}
