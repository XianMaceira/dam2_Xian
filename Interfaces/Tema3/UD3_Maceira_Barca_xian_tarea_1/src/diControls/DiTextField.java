/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package diControls;

import java.awt.Color;
import java.awt.Font;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author maceira_barca_xian
 */
public class DiTextField extends JTextField implements Serializable {
    
    private int diAnchor;
    private Font diFont;
    private Color diColor;

    /**
     * Get the value of diColor
     *
     * @return the value of diColor
     */
    public Color getDiColor() {
        return diColor;
    }

    /**
     * Set the value of diColor
     *
     * @param diColor new value of diColor
     */
    public void setDiColor(Color diColor) {
        this.diColor = diColor;
        this.setForeground(diColor);
    }

    /**
     * Get the value of diFont
     *
     * @return the value of diFont
     */
    public Font getDiFont() {
        return diFont;
    }

    /**
     * Set the value of diFont
     *
     * @param diFont new value of diFont
     */
    public void setDiFont(Font diFont) {
        this.diFont = diFont;
        this.setFont(diFont);
    }

    /**
     * Get the value of diAnchor
     *
     * @return the value of diAnchor
     */
    public int getDiAnchor() {
        return diAnchor;
    }

    /**
     * Set the value of diAnchor
     *
     * @param diAnchor new value of diAnchor
     */
    public void setDiAnchor(int diAnchor) {
        this.diAnchor = diAnchor;
        this.setColumns(diAnchor);
    }
    
    public DiTextField() {
        this.setDiColor(new Color(255, 0, 0));
    }
}
