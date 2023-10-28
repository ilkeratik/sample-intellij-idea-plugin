package com.iky.firstplugin.actions

import com.iky.firstplugin.views.exampleKotlinUIDSL
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.util.ui.JBUI
import javax.swing.JFrame

class UIDSLAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        print("helloooooo")
//        val dialog = DialogExample(e.project, true);
//        dialog.isOKActionEnabled = false
//        dialog.show()

//        UIDSLDialogWrapper().showAndGet()

        val component = JFrame()
        component.add(exampleKotlinUIDSL())
        component.rootPane.border=(JBUI.Borders.empty(15))
        component.pack()
        component.isVisible = true;

    }


}