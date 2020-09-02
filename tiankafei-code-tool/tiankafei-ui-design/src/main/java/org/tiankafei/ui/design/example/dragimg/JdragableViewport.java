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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JViewport;

/**
 * @author raistlic
 */
public class JdragableViewport extends JViewport {

    private static final long serialVersionUID = -5619209565273600223L;

    public JdragableViewport() {

        MouseDragHandler handler = this.new MouseDragHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    @Override
    public void setViewPosition(Point p) {

        p.x = Math.max(0, p.x);
        p.y = Math.max(0, p.y);

        Component v = getView();
        if (v != null) {

            Dimension d = v.getPreferredSize();
            Dimension size = getSize();
            p.x = Math.min(d.width - size.width, p.x);
            p.y = Math.min(d.height - size.height, p.y);
        }

        super.setViewPosition(p);
    }

    private class MouseDragHandler implements MouseListener, MouseMotionListener {

        private Point cursor = new Point();
        private Point view = new Point();

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            Point p = e.getPoint();
            int dx = cursor.x - p.x;
            int dy = cursor.y - p.y;
            view.x += dx;
            view.y += dy;

            setViewPosition(view);

            cursor = p;
            view = getViewPosition();
        }

        @Override
        public void mousePressed(MouseEvent e) {

            cursor = e.getPoint();
            view = getViewPosition();
        }
    }
}