package com.cyssxt.toolwindow.factory;
import com.cyssxt.toolwindow.MainToolWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MainToolWindowFactory implements ToolWindowFactory {

    JList container;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull com.intellij.openapi.wm.ToolWindow toolWindow) {
        MainToolWindow mainToolWindow = new MainToolWindow(toolWindow,project);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(mainToolWindow.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
