/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2005-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.meta.schema.views;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.axelor.db.mapper.Mapper;
import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlType
@JsonTypeName("panel-related")
public class PanelRelated extends AbstractPanel {

	@XmlAttribute(name = "field")
	private String name;

	@XmlAttribute(name = "type")
	private String serverType;

	@XmlAttribute(name = "form-view")
	private String formView;
	
	@XmlAttribute(name = "grid-view")
	private String gridView;
	
	@XmlAttribute
	private Boolean editable;

	@XmlAttribute
	private String orderBy;

	@XmlAttribute
	private String domain;
	
	@XmlAttribute
	private String target;

	@XmlAttribute(name = "target-name")
	private String targetName;

	@XmlAttribute
	private String onChange;
	
	@XmlAttribute
	private String onSelect;

	@XmlAttribute
	private Boolean canNew;

	@XmlAttribute
	private Boolean canView;

	@XmlAttribute
	private Boolean canEdit;

	@XmlAttribute
	private Boolean canRemove;

	@XmlAttribute
	private Boolean canSelect;

	@XmlElements({
		@XmlElement(name = "field", type = PanelField.class),
		@XmlElement(name = "button", type = Button.class),
	})
	private List<AbstractWidget> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServerType() {
		if (serverType == null) {
			try {
				Mapper mapper = Mapper.of(Class.forName(this.getModel()));
				serverType = mapper.getProperty(getName()).getType().name();
			} catch (Exception e) {
			}
		}
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getFormView() {
		return formView;
	}
	
	public void setFormView(String formView) {
		this.formView = formView;
	}
	
	public String getGridView() {
		return gridView;
	}
	
	public void setGridView(String gridView) {
		this.gridView = gridView;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Boolean getEditable() {
		return editable;
	}
	
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getOnChange() {
		return onChange;
	}
	
	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}
	
	public String getOnSelect() {
		return onSelect;
	}
	
	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}
	
	public Boolean getCanNew() {
		return canNew;
	}
	
	public void setCanNew(Boolean canNew) {
		this.canNew = canNew;
	}
	
	public Boolean getCanView() {
		return canView;
	}
	
	public void setCanView(Boolean canView) {
		this.canView = canView;
	}

	public Boolean getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}

	public Boolean getCanRemove() {
		return canRemove;
	}

	public void setCanRemove(Boolean canRemove) {
		this.canRemove = canRemove;
	}

	public Boolean getCanSelect() {
		return canSelect;
	}

	public void setCanSelect(Boolean canSelect) {
		this.canSelect = canSelect;
	}

	public List<AbstractWidget> getItems() {
		return process(items);
	}

	public void setItems(List<AbstractWidget> items) {
		this.items = items;
	}
}
