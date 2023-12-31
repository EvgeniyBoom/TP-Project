/*
package Screen.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton {
    public MenuButton() {
        // Init Color

        setFocusable(false);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setColor(Color.WHITE);
        colorOver=new Color(179,250,160);
        colorClick=new Color(152,184,144);
        borderColor=new Color(30,136,56);
        setContentAreaFilled(false);
        setBorderPainted(false);
        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorOver);
                over = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(color);
                over = false;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorClick);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    private boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    public Color getColorOver() {
        return colorOver;
    }
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    public Color getColorClick() {
        return colorClick;
    }
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    public Color getBorderColor() {
        return borderColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        // Border set 2 px
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(g);
    }
}
*/
