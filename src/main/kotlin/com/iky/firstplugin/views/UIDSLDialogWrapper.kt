package com.iky.firstplugin.views

import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JComponent

class UIDSLDialogWrapper : DialogWrapper(true) {
    init {
        init()
        title = "IKY Dialog with Kotlin UI DSL"
    }
    override fun createCenterPanel(): JComponent? {
        return exampleKotlinUIDSL()
    }

}