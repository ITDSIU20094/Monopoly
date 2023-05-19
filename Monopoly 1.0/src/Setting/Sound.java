package Setting;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sound extends JFrame {
    private Clip clip;
    private FloatControl gainControl;
    private JSlider volumeSlider;

    public Sound() {
        setTitle("Volume Control Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());

        // Tạo nút tải âm thanh
        JButton loadButton = new JButton("Load Sound");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSound();
            }
        });
        add(loadButton);

        // Tạo thanh trượt âm lượng
        volumeSlider = new JSlider(0, 100);
        volumeSlider.setPreferredSize(new Dimension(200, 20));
        volumeSlider.setEnabled(false);
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                adjustVolume();
            }
        });
        add(volumeSlider);

        setVisible(true);
    }

    private void loadSound() {
        try {
            // Đường dẫn đến tệp âm thanh
            String audioFilePath = "path/to/audio/file.wav";

            // Mở tệp âm thanh và tạo AudioInputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    Sound.class.getResourceAsStream(audioFilePath));

            // Lấy thông tin về âm thanh
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);

            // Tạo Clip từ thông tin
            clip = (Clip) AudioSystem.getLine(info);

            // Mở Clip
            clip.open(audioInputStream);

            // Lấy điều khiển âm lượng
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Cho phép điều chỉnh âm lượng
            volumeSlider.setEnabled(true);
            volumeSlider.setValue(50); // Đặt giá trị mặc định là 50%
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adjustVolume() {
        float volume = volumeSlider.getValue() / 100f; // Chuyển giá trị trong khoảng 0-100 thành khoảng 0.0-1.0
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * volume) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sound();
            }
        });
    }
}
