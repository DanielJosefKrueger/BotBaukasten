package main.utils.clipboard;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardUtil {

    /**
     * http://blog.mynotiz.de/programmieren/java-und-die-zwischenablage-21/
     * @return
     * @throws IOException
     * @throws UnsupportedFlavorException
     */
    public String getClipCoard() throws IOException, UnsupportedFlavorException {

        StringBuilder stringBuilder = new StringBuilder();

        Clipboard systemClipboard;
        systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferData = systemClipboard.getContents( null );
        for(DataFlavor dataFlavor : transferData.getTransferDataFlavors()){
            Object content = transferData.getTransferData( dataFlavor );
            if ( content instanceof String ) {
                stringBuilder.append(content);
            }
        }

        return stringBuilder.toString();
    }


    public void clear(){
        StringSelection stringSelection = new StringSelection("");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                stringSelection, null);


    }

}
