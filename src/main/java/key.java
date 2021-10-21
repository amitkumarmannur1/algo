import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Arrays;

public class key {

    public static void main(String[] args) {

        // This represents a cut-copy (Ctrl+X/Ctrl+C) operation.
        // The text will be copied to the clipboard
        // StringSelection is a Transferable implementation
        // class.
        String asd = "aasd";
        if (asd.length() > 2) {
            String b = asd.substring(0, 2);
        }
        StringSelection data = new StringSelection
                ("This is copied to the clipboard");
        StringSelection data2 = new StringSelection
                ("This isijlkto the jnkj");
        Clipboard cb = Toolkit.getDefaultToolkit()
                .getSystemClipboard();
        cb.setContents(data2, data);


        // This represents the paste (Ctrl+V) operation

        try {
            Transferable t = cb.getContents(null);
            if (t.isDataFlavorSupported(DataFlavor.stringFlavor))
                System.out.println(t.getTransferData(DataFlavor
                        .stringFlavor));
            if (t != null) {
                DataFlavor[] flavors = t.getTransferDataFlavors();
                if (flavors != null) {
                    System.out.println(Arrays.asList(flavors));
                }
            }
        } catch (UnsupportedFlavorException | IOException ex) {
            System.out.println("hjbnk");
        }
    }
}