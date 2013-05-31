/*******************************************************************************
 * Copyright (c) 2012 Kai Toedter and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Kai Toedter - initial API and implementation
 ******************************************************************************/

package org.ibertech.client.ui;

import com.google.gwt.user.cellview.client.CellTable;

public interface TableResources extends CellTable.Resources {

	/**
	 * The styles applied to the cell tables.
	 */
	interface TableStyle extends CellTable.Style {
	}

	
	@Source({ CellTable.Style.DEFAULT_CSS, "cellTable.css" })
	TableStyle cellTableStyle();

}