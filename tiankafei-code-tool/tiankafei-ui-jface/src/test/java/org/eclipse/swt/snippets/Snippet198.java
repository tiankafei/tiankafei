/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corporation and others.
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
package org.eclipse.swt.snippets;

/*
 * Create a path from some text
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 *
 * @since 3.1
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Snippet198 {
    public static void main(String[] args) {
        Display display = new Display();
        FontData data = display.getSystemFont().getFontData()[0];
        Font font = new Font(display, data.getName(), 96, SWT.BOLD | SWT.ITALIC);
        final Color green = display.getSystemColor(SWT.COLOR_GREEN);
        final Color blue = display.getSystemColor(SWT.COLOR_BLUE);
        final Path path;
        try {
            path = new Path(display);
            path.addString("SWT", 0, 0, font);
        } catch (SWTException e) {
            //Advanced Graphics not supported.
            //This new API requires the Cairo Vector engine on GTK and GDI+ on Windows.
            System.out.println(e.getMessage());
            display.dispose();
            return;
        }
        Shell shell = new Shell(display);
        shell.setText("Snippet 198");
        shell.addListener(SWT.Paint, e -> {
            GC gc = e.gc;
            gc.setBackground(green);
            gc.setForeground(blue);
            gc.fillPath(path);
            gc.drawPath(path);
        });
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        path.dispose();
        font.dispose();
        display.dispose();
    }
}
