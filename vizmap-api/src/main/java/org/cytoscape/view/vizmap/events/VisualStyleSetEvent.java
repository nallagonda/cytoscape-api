/*
 Copyright (c) 2008, The Cytoscape Consortium (www.cytoscape.org)

 The Cytoscape Consortium is:
 - Institute for Systems Biology
 - University of California San Diego
 - Memorial Sloan-Kettering Cancer Center
 - Institut Pasteur
 - Agilent Technologies

 This library is free software; you can redistribute it and/or modify it
 under the terms of the GNU Lesser General Public License as published
 by the Free Software Foundation; either version 2.1 of the License, or
 any later version.

 This library is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF
 MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and
 documentation provided hereunder is on an "as is" basis, and the
 Institute for Systems Biology and the Whitehead Institute
 have no obligations to provide maintenance, support,
 updates, enhancements or modifications.  In no event shall the
 Institute for Systems Biology and the Whitehead Institute
 be liable to any party for direct, indirect, special,
 incidental or consequential damages, including lost profits, arising
 out of the use of this software and its documentation, even if the
 Institute for Systems Biology and the Whitehead Institute
 have been advised of the possibility of such damage.  See
 the GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation,
 Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package org.cytoscape.view.vizmap.events;

import org.cytoscape.event.AbstractCyEvent;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;

/**
 * Event fired when a {@link VisualStyle} is set to a network view through 
 * {@linkplain VisualMappingManager#setVisualStyle(VisualStyle, org.cytoscape.view.model.CyNetworkView)}.
 * @CyAPI.Final.Class
 */
public final class VisualStyleSetEvent extends AbstractCyEvent<VisualMappingManager> {

	private final VisualStyle style;
	private final CyNetworkView view;

	/**
	 * Creates the event.
	 * 
	 * @param source Source of this event.  This is always {@link VisualMappingManager}.
	 * @param style The VisualStyle that was set to the network view.
	 * @param view The target CyNetworkView.
	 */
	public VisualStyleSetEvent(final VisualMappingManager source, final VisualStyle style, CyNetworkView view) {
		super(source, VisualStyleSetListener.class);
		this.style = style;
		this.view = view;
	}

	/**
	 * Get the VisualStyle that was set to the network view.
	 * @return The VisualStyle that was set to the network view.
	 */
	public VisualStyle getVisualStyle() {
		return style;
	}
	
	/**
	 * Get the The target network view model.
	 * @return The target CyNetworkView.
	 */
	public CyNetworkView getNetworkView() {
		return view;
	}
}