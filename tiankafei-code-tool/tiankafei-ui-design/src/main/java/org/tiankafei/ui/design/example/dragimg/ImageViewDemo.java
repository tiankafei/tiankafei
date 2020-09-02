package org.tiankafei.ui.design.example.dragimg;

/*
 * Copyright 2013 (raistlic@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 * @author raistlic
 */
public class ImageViewDemo extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 5247875670780714444L;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {

                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    JFrame f = new JFrame("Image View Demo");

                    f.setContentPane(new ImageViewDemo());

                    f.setSize(800, 600);
                    f.setLocationRelativeTo(null);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setVisible(true);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }

    private static final String LABEL_OPEN_FILE = "Open Image File";
    private static final Iterable<String> SUPPORTED_FILE_EXT = Arrays.asList(

            ".jpg", ".png"
    );

    private JimagePanel imagePanel;
    private Action openAction;
    private JTextField pathField;
    private JFileChooser fileChooser;

    ImageViewDemo() {

        super(new BorderLayout(5, 5));

        imagePanel = new JimagePanel();
        openAction = new OpenImageFileAction(LABEL_OPEN_FILE);
        pathField = new JTextField();
        pathField.setEditable(false);
        pathField.setOpaque(false);

        initLayout();
    }

    private void initLayout() {

        JViewport viewPort = new JdragableViewport();
        viewPort.setView(imagePanel);

        add(viewPort, BorderLayout.CENTER);

        JPanel control = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        control.add(pathField, gbc);

        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx += 1;
        control.add(new JButton(openAction), gbc);

        control.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(control, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private JFileChooser getFileChooser() {

        if (fileChooser == null) {

            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {

                    assert f != null;

                    if (f.isDirectory()) {

                        return true;
                    } else {

                        String fname = f.getName().toLowerCase();
                        for (String s : SUPPORTED_FILE_EXT) {
                            if (fname.endsWith(s)) {
                                return true;
                            }
                        }

                        return false;
                    }
                }

                @Override
                public String getDescription() {

                    return "Image Files";
                }
            });
            fileChooser.setDialogTitle(LABEL_OPEN_FILE);
        }
        return fileChooser;
    }

    private class OpenImageFileAction extends AbstractAction {

        private static final long serialVersionUID = -5507770495197699949L;

        private OpenImageFileAction(String name) {

            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser jfc = getFileChooser();
            int openResult = jfc.showOpenDialog(ImageViewDemo.this);
            if (openResult == JFileChooser.APPROVE_OPTION) {

                try {

                    File file = jfc.getSelectedFile();
                    BufferedImage image = ImageIO.read(file);
                    imagePanel.setImage(image);
                    pathField.setText(file.getAbsolutePath());
                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(ImageViewDemo.this, "Failed to open Image : " + ex.getMessage());
                }
            }
        }
    }
}