package SettingWindow;

import javax.swing.*;
import java.awt.*;

public class ImageItemRenderer extends JLabel implements ListCellRenderer<ImageItem> {
    public ImageItemRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ImageItem> list, ImageItem value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        // Set the image and name of the ImageItem
        if (value == null) {
            setText("");
            setIcon(null);
        }else {
            setIcon(new ImageIcon(value.getImage()));
            setText(value.getName());
        }

        // Set background and foreground colors based on selection
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        // Set the size and alignment of the label
        setPreferredSize(new Dimension(100, 20));
        setHorizontalAlignment(SwingConstants.CENTER);

        return this;
    }
}
