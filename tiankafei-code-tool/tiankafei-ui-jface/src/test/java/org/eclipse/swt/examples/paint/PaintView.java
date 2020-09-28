/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.examples.paint;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

/**
 * The view for the paint application.
 * All rendering happens inside the area created by createPartControl().
 *
 * @see ViewPart
 */
public class PaintView extends ViewPart {
    PaintExample instance = null;

    /**
     * Constructs a Paint view.
     */
    public PaintView() {
    }

    /**
     * Creates the example.
     *
     * @see ViewPart#createPartControl
     */
    @Override
    public void createPartControl(Composite parent) {
        instance = new PaintExample(parent);
        instance.createGUI(parent);

        /*** Add toolbar contributions ***/
        final IActionBars actionBars = getViewSite().getActionBars();
        IToolBarManager toolbarManager = actionBars.getToolBarManager();
        Tool tools[] = PaintExample.tools;
        String group = tools[0].group;
        toolbarManager.add(new GroupMarker(group));
        for (int i = 0; i < tools.length; i++) {
            Tool tool = tools[i];
            if (!tool.group.equals(group)) {
                toolbarManager.add(new Separator());
                toolbarManager.add(new GroupMarker(tool.group));
            }
            group = tool.group;
            PaintAction action = new PaintAction(tool);
            toolbarManager.appendToGroup(group, action);
            if (i == PaintExample.Default_tool || i == PaintExample.Default_fill || i == PaintExample.Default_linestyle) {
                action.setChecked(true);
            }
        }
        actionBars.updateActionBars();

        instance.setDefaults();
    }

    /**
     * Called when the View is to be disposed
     */
    @Override
    public void dispose() {
        instance.dispose();
        instance = null;
        super.dispose();
    }

    /**
     * Returns the Display.
     *
     * @return the display we're using
     */
    public Display getDisplay() {
        return instance.getDisplay();
    }

    /**
     * Called when we must grab focus.
     *
     * @see ViewPart#setFocus
     */
    @Override
    public void setFocus() {
        instance.setFocus();
    }

    /**
     * Action set glue.
     */
    class PaintAction extends Action {
        private int style;
        private Runnable action;

        public PaintAction(Tool tool) {
            super();
            String id = tool.group + '.' + tool.name;
            setId(id);
            style = tool.type == SWT.RADIO ? IAction.AS_RADIO_BUTTON : IAction.AS_PUSH_BUTTON;
            action = tool.action;
            setText(PaintExample.getResourceString(id + ".label"));
            setToolTipText(PaintExample.getResourceString(id + ".tooltip"));
            setDescription(PaintExample.getResourceString(id + ".description"));
            setImageDescriptor(ImageDescriptor.createFromFile(
                    PaintExample.class,
                    PaintExample.getResourceString(id + ".image")));
        }

        @Override
        public int getStyle() {
            return style;
        }

        @Override
        public void run() {
            action.run();
        }
    }
}