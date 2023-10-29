package com.iky.firstplugin.actions

import com.iky.firstplugin.views.BrowserUI
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.util.ui.JBUI
import javax.swing.JFrame

class WebsiteAction : AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
//        val frame = JFrame()
//        frame.add(JBCefBrowser("https://ilkeratik.com").component)
//        frame.size = Dimension(500,500)
//        frame.isVisible = true
        val component = JFrame()
        component.add(BrowserUI().websitesUI())
        component.rootPane.border=(JBUI.Borders.empty(15))
        component.pack()
        component.isVisible = true;
    }
}