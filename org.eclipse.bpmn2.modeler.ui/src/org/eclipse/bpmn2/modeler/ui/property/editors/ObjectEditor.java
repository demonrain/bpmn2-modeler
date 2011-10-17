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

package org.eclipse.bpmn2.modeler.ui.property.editors;

import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.property.AbstractBpmn2PropertiesComposite;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author Bob Brodt
 *
 */
public abstract class ObjectEditor {
	EObject object;
	EStructuralFeature feature;
	AbstractBpmn2PropertiesComposite parent;
	
	public ObjectEditor(AbstractBpmn2PropertiesComposite parent, EObject object, EStructuralFeature feature) {
		this.parent = parent;
		this.object = object;
		this.feature = feature;
	}
	
	public abstract Control createControl(Composite composite, String label, int style);
	
	public Control createControl(Composite composite, String label) {
		return createControl(composite,label,SWT.NONE);
	}
	
	public Control createControl(String label) {
		return createControl(parent,label,SWT.NONE);
	}
	
	protected FormToolkit getToolkit() {
		return parent.getToolkit();
	}
	
	protected BPMN2Editor getDiagramEditor() {
		return parent.getDiagramEditor();
	}

	protected Diagram getDiagram() {
		return getDiagramEditor().getDiagramTypeProvider().getDiagram();
	}
	
	protected Label createLabel(Composite parent, String name) {
		Label label = getToolkit().createLabel(parent, name);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		return label;
	}
}
