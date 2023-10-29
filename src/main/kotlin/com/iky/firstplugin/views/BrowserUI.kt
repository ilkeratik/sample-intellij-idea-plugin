package com.iky.firstplugin.views

import com.intellij.ide.ui.laf.darcula.ui.DarculaButtonUI
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.ClientProperty
import com.intellij.ui.dsl.builder.TopGap
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import com.intellij.ui.dsl.gridLayout.VerticalAlign
import com.intellij.ui.jcef.JBCefBrowser
class BrowserUI {
    private val jBrowser = JBCefBrowser("https://ilkeratik.com");
     fun websitesUI(): DialogPanel {
        return panel {
            val model = Model()
            panel {
                row("Go to:") {
                    button("Website") { loadWebsite("https://ilkeratik.com") }
                        .applyToComponent {
                            putClientProperty("gotItButton", true)
                            ClientProperty.put(this, DarculaButtonUI.DEFAULT_STYLE_KEY, true)
                        }
                    button("Github") { loadWebsite("https://github.com/ilkeratik") }
                        .applyToComponent {
                            putClientProperty("gotItButton", true)
                            ClientProperty.put(this, DarculaButtonUI.DEFAULT_STYLE_KEY, true)
                        }

                }
                row{
                    button("Back") { jBrowser.cefBrowser.goBack() }
                    button("Forward") { jBrowser.cefBrowser.goForward() }
                }.topGap(TopGap.SMALL)
            }

            panel{
                row {
                    cell(jBrowser.component)
                }
            }

        }
    }
    private fun loadWebsite(website : String){
        jBrowser.loadURL(website);
    }
}