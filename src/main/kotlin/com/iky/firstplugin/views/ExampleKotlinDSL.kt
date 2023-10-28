package com.iky.firstplugin.views

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.JBColor
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindIntValue
import com.intellij.ui.dsl.builder.bindValue
import com.intellij.ui.dsl.builder.panel
import java.awt.Color

fun exampleKotlinUIDSL(): DialogPanel {
    return panel {
        val model = Model()
        panel {
            row("Panel.panel row:") {
                textField()
            }.rowComment("Panel.panel method creates sub-panel that occupies whole width and uses own grid inside")
        }

        rowsRange {
            row("Panel.rowsRange row:") {
                textField()
            }.rowComment("Panel.rowsRange is similar to Panel.panel but uses the same grid as parent. " +
                    "Useful when grouped content should be managed together with RowsRange.enabledIf for example")
        }

        group("Panel.group") {
            row("Panel.group row:") {
                textField()
            }.rowComment("Panel.group adds panel with independent grid, title and some vertical space before/after the group")
        }

        groupRowsRange("Panel.groupRowsRange") {
            row("Panel.groupRowsRange row:") {
                textField()
            }.rowComment("Panel.groupRowsRange is similar to Panel.group but uses the same grid as parent. " +
                    "See how aligned Panel.rowsRange row")
        }

        collapsibleGroup("Panel.collapsible&Group") {
            row("Panel.collapsibleGroup row:") {
                textField()
            }.rowComment("Panel.collapsibleGroup adds collapsible panel with independent grid, title and some vertical " +
                    "space before/after the group. The group title is focusable via the Tab key and supports mnemonics")
        }

        var value = true
        buttonsGroup("Panel.buttonGroup:") {
            row {
                radioButton("true", true)
            }
            row {
                radioButton("false", false)
            }.rowComment("Panel.buttonGroup unions Row.radioButton in one group. Must be also used for Row.checkBox if they are grouped " +
                    "with some title")
        }.bind({ value }, { value = it })

        separator()
            .rowComment("Use separator() for horizontal separator")

        row {
            label("Use Row.panel for creating panel in a cell:")
            panel {
                row("Sub panel row 1:") {
                    textField()
                }
                row("Sub panel row 2:") {
                    textField()
                }
            }
        }

        row("slider:") {
            slider(0, 100, 10, 50)
                .bindValue(model::slider)
        }
        row("spinner:") {
            spinner(0..100)
                .bindIntValue(model::spinner)
        }
        row("Row") {
            checkBox("Option 1")
            textField()
                .resizableColumn()
            link("Config...") {}
        }
        buttonsGroup(title = "Panel.buttonGroup:") {
            row{
                radioButton("true",22)
                radioButton("false",333)
                radioButton("cdd",111)
            }
        }.bind(model::radioButtonColor)
    }
}
data class Model(
    var checkbox: Boolean = false,
    var textField: String = "",
    var intTextField: Int = 0,
    var comboBoxColor: Color = JBColor.gray,
    var slider: Int = 0,
    var spinner: Int = 0,
    var radioButtonColor: Int = 1,
)