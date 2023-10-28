package com.iky.firstplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.Dimension
import javax.swing.JFrame

class WebsiteAction : AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
        val frame = JFrame()
        frame.add(JBCefBrowser("https://ilkeratik.com").component)
        frame.size = Dimension(500,500)
        frame.isVisible = true
    }
}