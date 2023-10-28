package com.iky.firstplugin.views;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class DialogExample extends DialogWrapper {
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JPanel panel1;
    private JCheckBox checkBox1;

    public DialogExample() {
        super(true); // use current window as parent
        init();
    }
    public DialogExample(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
        init();
    }
    @Override
    public void init() {
        super.init();
        setTitle("Iky Dialog");

        panel1.setBackground(JBColor.white);
        panel1.setPreferredSize(new Dimension(300,300));

        label1.setText("Hello iky");

        button1.setText("First");
        button1.setForeground(JBColor.blue);

        button2.setText("Second");
        button2.setForeground(JBColor.red);
    }
    @Override
    protected @Nullable JComponent createCenterPanel() {
        return panel1;
    }
}
