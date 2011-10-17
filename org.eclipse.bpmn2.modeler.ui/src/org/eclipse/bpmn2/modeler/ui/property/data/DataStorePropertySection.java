/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/

package org.eclipse.bpmn2.modeler.ui.property.data;

import org.eclipse.bpmn2.DataStore;
import org.eclipse.bpmn2.DataStoreReference;
import org.eclipse.bpmn2.modeler.ui.property.AbstractBpmn2PropertiesComposite;
import org.eclipse.bpmn2.modeler.ui.property.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.ui.property.DefaultPropertiesComposite;
import org.eclipse.bpmn2.modeler.ui.property.PropertiesCompositeFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Bob Brodt
 *
 */
public class DataStorePropertySection extends AbstractBpmn2PropertySection {

	static {
		// register the DataStorePropertiesComposite for rendering DataStore objects
		PropertiesCompositeFactory.register(DataStore.class, DataStorePropertiesComposite.class);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.bpmn2.modeler.ui.property.AbstractBpmn2PropertySection#createSectionRoot()
	 */
	@Override
	protected AbstractBpmn2PropertiesComposite createSectionRoot() {
		return new DataStorePropertiesComposite(this);
	}

	@Override
	protected EObject getBusinessObjectForPictogramElement(PictogramElement pe) {
		EObject bo = super.getBusinessObjectForPictogramElement(pe);
		if (bo instanceof DataStoreReference) {
			return ((DataStoreReference) bo).getDataStoreRef();
		} else if (bo instanceof DataStore) {
			return bo;
		}
		
		return null;
	}
	
	public class DataStorePropertiesComposite extends DefaultPropertiesComposite {

		public DataStorePropertiesComposite(Composite parent, int style) {
			super(parent, style);
		}

		/**
		 * @param section
		 */
		public DataStorePropertiesComposite(AbstractBpmn2PropertySection section) {
			super(section);
		}
	}
}
