package com.iky.firstplugin.toolwindows

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import org.apache.commons.lang3.StringUtils
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel


class TimeToolWindowFactory() : ToolWindowFactory {
    private val contentPanel = JPanel()
    private val currentDate = JLabel()
    private val timeZone = JLabel()
    private val currentTime = JLabel()

    constructor(toolWindow: ToolWindow) : this() {
        contentPanel.layout = BorderLayout(0, 20)
        contentPanel.border = BorderFactory.createEmptyBorder(40, 0, 0, 0)
        contentPanel.add(createCalendarPanel(), BorderLayout.PAGE_START)
        contentPanel.add(createControlsPanel(toolWindow), BorderLayout.CENTER)
        updateCurrentDateTime()
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent = TimeToolWindowFactory(toolWindow);
        val content = ContentFactory.getInstance().createContent(toolWindowContent.contentPanel, "", false);
        toolWindow.contentManager.addContent(content);
    }
    private fun createCalendarPanel(): JPanel? {
        val calendarPanel = JPanel()
        calendarPanel.add(currentDate)
        calendarPanel.add(timeZone)
        calendarPanel.add(currentTime)
        return calendarPanel
    }
    private fun createControlsPanel(toolWindow: ToolWindow): JPanel? {
        val controlsPanel = JPanel()
        val refreshDateAndTimeButton = JButton("Refresh")
        refreshDateAndTimeButton.addActionListener { e: ActionEvent? -> updateCurrentDateTime() }
        controlsPanel.add(refreshDateAndTimeButton)
        val hideToolWindowButton = JButton("Hide")
        hideToolWindowButton.addActionListener { e: ActionEvent? -> toolWindow.hide(null) }
        controlsPanel.add(hideToolWindowButton)
        return controlsPanel
    }
    fun updateCurrentDateTime() {
        var calendar = Calendar.getInstance()
        currentDate.text = getCurrentDate(calendar);
        timeZone.text = getTimeZone(calendar);
        currentTime.text = getCurrentTime(calendar);
    }
    private fun getCurrentDate(calendar: Calendar): String? {
        return ((calendar[Calendar.DAY_OF_MONTH].toString() + "/"
                + (calendar[Calendar.MONTH] + 1)) + "/"
                + calendar[Calendar.YEAR])
    }
    private fun getTimeZone(calendar: Calendar): String? {
        val gmtOffset = calendar[Calendar.ZONE_OFFSET].toLong() // offset from GMT in milliseconds
        val gmtOffsetString = (gmtOffset / 3600000).toString()
        return if (gmtOffset > 0) "GMT + $gmtOffsetString" else "GMT - $gmtOffsetString"
    }

    private fun getCurrentTime(calendar: Calendar): String? {
        return getFormattedValue(calendar, Calendar.HOUR_OF_DAY) + ":" + getFormattedValue(calendar, Calendar.MINUTE)
    }
    private fun getFormattedValue(calendar: Calendar, calendarField: Int): String? {
        val value = calendar[calendarField]
        return StringUtils.leftPad(value.toString(), 2, "0")
    }


}