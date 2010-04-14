/*
This file is part of OFC4J.

OFC4J is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as
published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

OFC4J is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

See <http://www.gnu.org/licenses/lgpl-3.0.txt>.
*/

package ofc4j.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import ofc4j.OFC;
import ofc4j.OFCException;
import ofc4j.model.axis.XAxis;
import ofc4j.model.axis.YAxis;
import ofc4j.model.elements.Element;


/**
 * This is the most important class in the Java OFC library.
 * Start here, configuring the title, axes, legends, labels,
 * and draw-able elements in your chart.  Coerce the
 * object to a String with the toString() method to get the
 * chart data back out.
 */
public class Chart {
    private Text title;
    private XAxis x_axis;
    private YAxis y_axis;
    private YAxis y_axis_right;
    private Text y_legend;
    private Text x_legend;
    private String bg_colour;
    private Collection<Element> elements = new HashSet<Element>();

    public XAxis getXAxis() {
        return x_axis;
    }
    
    public Chart() {
        //nothing...
    }
    
    public Chart(String titleText) {
        this(titleText, null);
    }
    
    public Chart(String titleText, String style) {
        this.setTitle(new Text(titleText, style));
    }

    public Chart setXAxis(XAxis x_axis) {
        this.x_axis = x_axis;
        return this;
    }

    public YAxis getYAxis() {
        return y_axis;
    }

    public Chart setYAxis(YAxis y_axis) {
        this.y_axis = y_axis;
        return this;
    }
    
    public Chart setYAxisRight(YAxis y_axis_right) {
        this.y_axis_right = y_axis_right;
        return this;
    }
    
    public YAxis getYAxisRight() {
        return y_axis_right;
    }

    public Text getTitle() {
        return title;
    }

    public Chart setTitle(Text title) {
        this.title = title;
        return this;
    }
    
    public Text getXLegend() {
        return x_legend;
    }
    
    public Chart setXLegend(Text x_legend) {
        this.x_legend = x_legend;
        return this;
    }
    
    public Text getYLegend() {
        return y_legend;
    }

    public Chart setYLegend(Text y_legend) {
        this.y_legend = y_legend;
        return this;
    }
    
    public String getBackgroundColour() {
        return bg_colour;
    }
    
    public Chart setBackgroundColour(String bg_colour) {
        this.bg_colour = bg_colour;
        return this;
    }

    public Collection<Element> getElements() {
        return elements;
    }
    
    public Chart setElements(Collection<Element> elements) {
        this.elements.clear();
        this.elements.addAll(elements);
        return this;
    }
    
    public Chart addElements(Element... e) {
        elements.addAll(Arrays.asList(e));
        return this;
    }
    
    public Chart addElements(Collection<Element> coll) {
        elements.addAll(coll);
        return this;
    }
    
    public boolean removeElement(Element e) {
        return elements.remove(e);
    }
    
    public Element getElementByText(String text) {
        for (Element e : getElements()) {
            if (text.equals(e.getText())) return e;
        }
        return null;
    }
    
    @Override
    /**
     * @throws OFCException can throw an OFCException if there is a problem
     * rendering this Chart object.  This exception would indicate an issue
     * with the OFC4J library itself.
     */
    public String toString() throws OFCException {
        return OFC.getInstance().render(this);
    }
}
