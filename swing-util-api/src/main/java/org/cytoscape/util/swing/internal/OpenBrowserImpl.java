/*
  File: OpenBrowserImpl.java

  Copyright (c) 2006, The Cytoscape Consortium (www.cytoscape.org)

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

//-------------------------------------------------------------------------
// $Revision: 13206 $
// $Date: 2008-02-26 16:37:29 -0800 (Tue, 26 Feb 2008) $
// $Author: kono $
//-------------------------------------------------------------------------
package org.cytoscape.util.swing.internal;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.cytoscape.property.CyProperty;
import org.cytoscape.util.swing.OpenBrowser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenBrowserImpl implements OpenBrowser {

	private final Logger logger = LoggerFactory.getLogger(OpenBrowserImpl.class);

	private final Properties props;

	private final static String UNIX_PATH = "htmlview";
	private final static String MAC_PATH = "open";
	private final static String WIN_PATH = "rundll32 url.dll,FileProtocolHandler";

	public OpenBrowserImpl(CyProperty<Properties> cyProps) {
		if ( cyProps == null )
			throw new NullPointerException("Properties is null");	
		this.props = cyProps.getProperties();
	}

	/**
	 * Opens the specified URL in the system default web browser. 
	 * @param url The URL to open
	 * @return true if the URL opens successfully.
	 */
	public boolean openURL(String url) {
		
		Desktop desktop  = Desktop.getDesktop();
		
		try{
			URI uri = new URI(url);
			desktop.browse(uri);
		}catch (IOException ioe) {
			
			logger.warn("Open browser IOException",ioe);	
			return false;
			
		} catch (URISyntaxException e) {
			
			logger.warn("Url conversion to URI exception", e);
			return false;
			
		}
		
		return true;
	}

}
