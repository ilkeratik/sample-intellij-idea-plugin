package com.iky.firstplugin.toolwindows

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.BorderLayout
import java.util.*
import javax.swing.BorderFactory
import javax.swing.JPanel
import com.intellij.icons.AllIcons

class AssistantWindowFactory() : ToolWindowFactory {
    private val contentPanel = JPanel()
    private val jBrowser = JBCefBrowser("https://ilkeratik.com");
    constructor(toolWindow: ToolWindow) : this() {
        contentPanel.layout = BorderLayout(2, 2)
        contentPanel.border = BorderFactory.createEmptyBorder(10,8,10,8)
        contentPanel.add(controlPanelUI(), BorderLayout.PAGE_START)
        contentPanel.add(websiteUI(), BorderLayout.CENTER)

    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent = AssistantWindowFactory(toolWindow);
        val content = ContentFactory.getInstance().createContent(toolWindowContent.contentPanel, "", false);
        toolWindow.contentManager.addContent(content);
    }

    fun websiteUI(): DialogPanel {
        return panel{
            row {
                cell(jBrowser.component)
            }
        }
    }

    fun controlPanelUI(): DialogPanel{
        val model = Model()
        return panel{
            row{
                text("Hey! Welcome to IKY Assistant.").bold()
            }
            collapsibleGroup("Setup") {
                row("What result you want?") {
                    textField()
                }.rowComment("Explain to AI e.g. type the focused keywords")
                buttonsGroup(title = "Choose an approach:") {
                    row{
                        radioButton("Imaginative",1)
                        radioButton("Declarative",2)
                        radioButton("Abstract",3)
                    }.rowComment("Characteristics of your assistant!")
                }.bind(model::methodRadioButton)
                row("Epoch count:") {
                    slider(0, 100, 10, 50)
                        .bindValue(model::slider)
                }.rowComment("Learning steps count for better results, and rate of generative improvement")
                row("Choose a theme:") {
                    comboBox(Color.values().toList())
                        .bindItem(model::comboBoxColor.toNullableProperty())
                }
            }

        }
    }
}

data class Model(
    var slider: Int = 20,
    var spinner: Int = 0,
    var methodRadioButton: Int = 1,
    var comboBoxColor: Color = Color.GREY,
)

enum class Color {
    WHITE,
    GREY,
    BLACK
}