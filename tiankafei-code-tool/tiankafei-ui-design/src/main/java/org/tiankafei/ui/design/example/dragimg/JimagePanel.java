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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JPanel;


/**
 * @author raistlic
 */
public class JimagePanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -627863328842468969L;
    private static final Color GRID_1 = Color.GRAY.brighter();
    private static final Color GRID_2 = GRID_1.brighter();
    private static final int GRID_SIZE = 10;

    private Image image;

    public void setImage(Image image) {

        // although not checked, this method should be called with-in EDT.

        this.image = image;
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {

        if (image == null) {
            return getMinimumSize();
        } else {

            Insets i = getInsets();
            return new Dimension(
                    i.left + i.right + image.getWidth(this),
                    i.top + i.bottom + image.getHeight(this));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(GRID_1);
        g.fillRect(0, 0, width, height);

        g.setColor(GRID_2);
        for (int x = 0, y = 0, line = 0; y < height; ) {

            g.fillRect(x, y, GRID_SIZE, GRID_SIZE);
            x += 2 * GRID_SIZE;
            if (x > width) {

                y += GRID_SIZE;
                line = (line + 1) % 2;
                x = line * GRID_SIZE;
            }
        }

        Insets i = getInsets();
        g.drawImage(image, i.left, i.top, this);
    }
} 