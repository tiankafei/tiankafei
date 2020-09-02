package org.tiankafei.ui.report.panel.utils.htmldrawer;

import com.fr.report.write.Note;
import org.tiankafei.ui.report.model.TiankafeiStringNote;

/**
 * @author 甜咖啡
 */
public class TiankafeiNoteFactory {

    public static AbstractTiankafeiDrawer createHtmlDrawer(Note note) {
        AbstractTiankafeiDrawer abstractTiankafeiDrawer = null;
        if (note instanceof TiankafeiStringNote) {
            abstractTiankafeiDrawer = new TiankafeiStringNoteDrawer();
        } else {
            abstractTiankafeiDrawer = new TiankafeiNoteDrawer();
        }
        return abstractTiankafeiDrawer;
    }

}
