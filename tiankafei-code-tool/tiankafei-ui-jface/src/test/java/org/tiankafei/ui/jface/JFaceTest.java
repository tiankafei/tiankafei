package org.tiankafei.ui.jface;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 */
public class JFaceTest {

    @Test
    public void test() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("hello world! Window");
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}
