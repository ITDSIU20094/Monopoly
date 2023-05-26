package SettingWindow;


import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class ImageComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Lấy đường dẫn đến hình ảnh dựa trên giá trị của ComboBox
        String imagePath = "/Tireddd/assets/Pawn/" + value.toString() + ".png";

        // Tạo ImageIcon từ đường dẫn hình ảnh
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));

        // Đặt hình ảnh vào label
        label.setIcon(icon);

        return label;
    }
}
