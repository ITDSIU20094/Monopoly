package SettingWindow;


import java.awt.Component;
import java.util.Objects;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class ImageComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);


        String imagePath = "/Monopoly/.assets/Pawn/" + value.toString() + ".png";


        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));


        label.setIcon(icon);

        return label;
    }
}
