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


<<<<<<< HEAD
        String imagePath = "/Monopoly/.assets/Pawn/" + value.toString() + ".png";
=======
        String imagePath = "/Pawn/" + value.toString() + "1.png";
>>>>>>> 05292851b95f90c684febdc8225cb6106049e6df


        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));


        label.setIcon(icon);

        return label;
    }
}
